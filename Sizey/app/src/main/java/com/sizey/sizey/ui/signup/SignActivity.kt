package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.sizey.sizey.R
import com.sizey.sizey.listener.GenderButtonListener
import com.sizey.sizey.ui.adapter.SignPagerAdapter
import kotlinx.android.synthetic.main.activity_sign.*
import kotlinx.android.synthetic.main.fragment_email.*
import kotlinx.android.synthetic.main.fragment_signup_gendernick.*
import kotlinx.android.synthetic.main.fragment_signup_heightweight.*
import kotlinx.android.synthetic.main.fragment_signup_password.*
import kotlinx.android.synthetic.main.sign_up_toolbar.*
import org.jetbrains.anko.toast
import kotlin.random.Random

class SignActivity : AppCompatActivity(), GenderButtonListener {

    // firebase
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var adapter: SignPagerAdapter

    // sign info
    private var mEmail = ""
    private var mPw = ""
    private var mGender = ""
    private var mNick: String? = null
    private var mHeight: Double? = null
    private var mWeight: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)


        

        // saved id
//        vp_sign.offscreenPageLimit=2

        // un saved id
        vp_sign.offscreenPageLimit = 4 // 5

        adapter = SignPagerAdapter(supportFragmentManager)
        adapter.addItem(EmailFragment())
        adapter.addItem(SignUpPasswordFragment())
        adapter.addItem(SignUpGenderNickFragment())
        adapter.addItem(SignUpHeightWeightFragment())

        vp_sign.adapter = adapter
        setToolbarTitle()

        firebaseAuth = FirebaseAuth.getInstance()

        btn_next.setOnClickListener { nextPage() }
        btn_signup_toolbar_back.setOnClickListener { backPage() }
        val s = adapter.items[2] as SignUpGenderNickFragment
        s.setGenderListener(this)
    }

    private fun setToolbarTitle() {
        if (vp_sign.currentItem == 0) {
            tv_signup_toolbar_title.text = "이메일로 시작하기"
        } else {
            tv_signup_toolbar_title.text = "회원가입"
        }
    }

    private fun backPage() {
        if (vp_sign.currentItem == 0) {
            super.onBackPressed()
        } else {
            vp_sign.currentItem = vp_sign.currentItem - 1
            setToolbarTitle()
        }
    }

    private fun nextPage() {

        when (vp_sign.currentItem) {
            0 -> {
                mEmail = adapter.items[0].ed_email.text.toString()
                vp_sign.currentItem = vp_sign.currentItem + 1
                Log.d(TAG, "이메일1: $mEmail")
            }
            1 -> {
                mPw = adapter.items[1].ed_sign_up_pw.text.toString()
                vp_sign.currentItem = vp_sign.currentItem + 1
                Log.d(TAG, "이메일2: $mEmail")
            }
            2 -> {
                val nick = adapter.items[2].ed_nick.text.toString()

                mNick = if (nick.isNotEmpty())
                    nick
                else
                    "User${kotlin.math.abs(Random.nextLong())}"

                vp_sign.currentItem = vp_sign.currentItem + 1
                btn_next.text = "가입하기"
            }
            3 -> {
                val height = adapter.items[3].ed_sign_up_height.text.toString()
                val weight = adapter.items[3].ed_sign_up_weight.text.toString()

                mHeight = if (height.isNotEmpty())
                    height.toDouble()
                else
                    0.0
                mWeight = if (weight.isNotEmpty())
                    weight.toDouble()
                else
                    0.0
                signUpFirebase()
            }
        }
        setToolbarTitle()
    }

    /*private fun firebaseLogin(){
        firebaseAuth.signInWithEmailAndPassword(ed_email.text.toString(),ed_pw.text.toString())
            .addOnCompleteListener {
                if (it.isSuccessful){
                    toast("로그인 성공")
                }
                else{
                    toast("로그인 실패")
                }
            }
    }*/

    private fun signUpFirebase() {
        Log.d(TAG, ": signUpFirebase")
        firebaseAuth.createUserWithEmailAndPassword(mEmail, mPw).addOnCompleteListener {
            if (it.isSuccessful) {
                toast("회원가입 성공")
                saveProfileFirebase(it.getResult()!!.user!!.uid)
            } else
                toast("회원가입 실패")
        }
    }

    private fun saveProfileFirebase(uId: String) {
        val db = FirebaseFirestore.getInstance()

        val profile = hashMapOf(
            "gender" to mGender,
            "nick" to mNick,
            "height" to mHeight,
            "weight" to mWeight
        )
        db.collection("users").document(uId).set(profile)
            .addOnSuccessListener { toast("프로필 저장 완료") }
            .addOnFailureListener {
                Log.d(TAG, ": $it")
                toast("프로필 저장 실패")
            }


    }


    override fun onBackPressed() {
        if (vp_sign.currentItem == 1) {
            super.onBackPressed()
        } else {
            vp_sign.currentItem = vp_sign.currentItem - 1
        }
    }

    override fun onResume() {
        Log.d(TAG, ": onResume")
        super.onResume()

    }

    override fun onStop() {
        Log.d(TAG, ": onStop")
        super.onStop()

    }

    override fun onStart() {
        Log.d(TAG, ": onStart")
        super.onStart()

    }

    override fun onDestroy() {
        Log.d(TAG, ": onDestroy")
        super.onDestroy()

    }

    companion object {
        private const val TAG = "LoginActivity.kt"
    }

    override fun selectGender(gender: String) {
        mGender = gender
    }


}