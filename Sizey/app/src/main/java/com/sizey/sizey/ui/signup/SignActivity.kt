package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sizey.sizey.R
import com.sizey.sizey.listener.GenderButtonListener
import com.sizey.sizey.ui.adapter.SignPagerAdapter
import kotlinx.android.synthetic.main.activity_sign.*
import kotlinx.android.synthetic.main.fragment_email.*
import kotlinx.android.synthetic.main.fragment_signup_heightweight.*
import kotlinx.android.synthetic.main.fragment_signup_password.*
import kotlinx.android.synthetic.main.sign_up_toolbar.*
import org.jetbrains.anko.toast

class SignActivity : AppCompatActivity() {

    // firebase
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var adapter: SignPagerAdapter

    // sign info
    private var mEmail = ""
    private var mPw = ""
    private var mGender = ""
    private var mHeight = 0.0
    private var mWeight = 0.0

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


//        btn_signup_toolbar_back

        firebaseAuth = FirebaseAuth.getInstance()

//        btn_next.setOnClickListener { firebaseLogin() }
        btn_next.setOnClickListener { nextPage() }
        btn_signup_toolbar_back.setOnClickListener { backPage() }
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
                }
                1 -> {
                    mPw = adapter.items[1].ed_sign_up_pw.text.toString()
                    vp_sign.currentItem = vp_sign.currentItem + 1
                }
                2 -> {
                    val s = adapter.items[2] as SignUpGenderNickFragment
                    s.setGenderListener(object : GenderButtonListener {
                        override fun selectGender(gender: String) {
                            mGender = gender
                        }
                    })
                    vp_sign.currentItem = vp_sign.currentItem + 1
//                    btn_next.text = "가입하기"

                }
                3 -> {
                    mHeight = adapter.items[3].ed_sign_up_height.text.toString().toDouble() ?: 0.0
                    mWeight = adapter.items[3].ed_sign_up_weight.text.toString().toDouble() ?: 0.0
                    Log.d(TAG, "키 : $mHeight")
                    Log.d(TAG, "몸무게 : $mWeight")
                    firebaseSignUp()
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

    private fun firebaseSignUp() {
        Log.d(TAG, ": firebaseSignUp")
        firebaseAuth.createUserWithEmailAndPassword(mEmail, mPw).addOnCompleteListener {
            if (it.isSuccessful)
                toast("회원가입 성공")
            else
                toast("회원가입 실패")
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


}