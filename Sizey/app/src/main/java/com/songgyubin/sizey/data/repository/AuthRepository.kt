package com.songgyubin.sizey.data.repository

import android.app.Activity
import android.util.Log
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.songgyubin.sizey.data.local.User
import io.reactivex.Completable
import java.util.*
import kotlin.random.Random


class AuthRepository {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDb: FirebaseFirestore = FirebaseFirestore.getInstance()

    private var facebookCallbackManager: CallbackManager = CallbackManager.Factory.create()

    fun emailLogin(user: User) = Completable.create { emitter ->
        firebaseAuth.signInWithEmailAndPassword(user.userId, user.userPw)
            .addOnCompleteListener { task ->
                if (!emitter.isDisposed) {
                    if (task.isComplete) {
                        emitter.onComplete()
                    } else {
                        emitter.onError(task.exception!!)

                    }
                }
            }
    }

    fun createEmail(user: User) = Completable.create { emitter ->
        firebaseAuth.createUserWithEmailAndPassword(user.userId, user.userPw)
            .addOnCompleteListener { task ->
                if (!emitter.isDisposed) {
                    if (task.isComplete) {
                        emitter.onComplete()

                    } else {
                        emitter.onError(task.exception!!)
                    }

                }
            }
    }

    fun saveNick(user: User) = Completable.create { emitter ->
         user.userNick?:"닉네임${Random.nextLong(1000,1000000)}"
        firebaseDb.collection("users")
            .document(user.userId)
            .set(user)
            .addOnSuccessListener {
                Log.d(TAG, ": saveDB Success")
            }
            .addOnFailureListener {
                Log.d(TAG, ": ${it.printStackTrace()}")
            }
    }

    fun facebookLogin(activity:Activity) = Completable.create {

        emitter->
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile", "email"))
        LoginManager.getInstance().registerCallback(facebookCallbackManager, object :
            FacebookCallback<LoginResult> {

            override fun onSuccess(result: LoginResult?) {
                //페이스북 로그인 성공
                emitter.onComplete()
                handleFacebookAccessToken(result?.accessToken)

            }
            override fun onCancel() {
                //페이스북 로그인 취소

            }

            override fun onError(error: FacebookException?) {
                //페이스북 로그인 실패
                emitter.onError(error!!.fillInStackTrace())
            }
        })
    }
    private fun handleFacebookAccessToken(token: AccessToken?) {
        Log.d("MainActivity", "handleFacebookAccessToken:$token")
        if (token != null) {
            val credential = FacebookAuthProvider.getCredential(token.token)
            firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener {
                    Log.d(TAG, ": ${it.user.toString()}")
                }
                .addOnFailureListener {
                    Log.d(TAG, ": ${it.printStackTrace()}")
                }

        }
    }


    companion object {
        private const val TAG = "AuthRepository.kt"
    }


}