package com.sizey.sizey.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResult
import com.sizey.sizey.R
import com.sizey.sizey.ui.adapter.SignPagerAdapter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.sign_up_toolbar.*

class LoginActivity : AppCompatActivity() {

    // firebase
//    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var adapter: SignPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // saved id
//        vp_sign.offscreenPageLimit=2

        // un saved id
        vp_sign.offscreenPageLimit = 3 // 5
        adapter = SignPagerAdapter(supportFragmentManager)
        adapter.addItem(EmailFragment())
        adapter.addItem(PasswordFragment())
        adapter.addItem(SexNickFragment())

        vp_sign.adapter = adapter
        setToolbarTitle()


//        btn_signup_toolbar_back

//        firebaseAuth = FirebaseAuth.getInstance()

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
        if (vp_sign.currentItem == adapter.count - 1) {
            // 완료 btn

        } else {
            vp_sign.currentItem = vp_sign.currentItem + 1
            setToolbarTitle()
        }
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

    override fun onBackPressed() {
        if (vp_sign.currentItem == 0) {

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