package com.sizey.sizey.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sizey.sizey.R
import com.sizey.sizey.ui.adapter.SignPagerAdapter
import com.sizey.sizey.ui.signup.SexNickFragment
import com.sizey.sizey.ui.signup.SignUpPasswordFragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_next
import kotlinx.android.synthetic.main.fragment_email.*
import kotlinx.android.synthetic.main.fragment_signup_password.*
import kotlinx.android.synthetic.main.sign_up_toolbar.*

class SignActivity : AppCompatActivity() {

    // firebase
//    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var adapter: SignPagerAdapter

    // sign info
    private var email = ""
    private var pw = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // saved id
//        vp_sign.offscreenPageLimit=2

        // un saved id
        vp_sign.offscreenPageLimit = 3 // 5
        adapter = SignPagerAdapter(supportFragmentManager)
        adapter.addItem(EmailFragment())
        adapter.addItem(SignUpPasswordFragment())
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
        if (vp_sign.currentItem == 1) {
            super.onBackPressed()
        } else {
            vp_sign.currentItem = vp_sign.currentItem - 1
            setToolbarTitle()
        }
    }

    fun nextPage() {
        if (vp_sign.currentItem == adapter.count - 1) {
            // 완료 btn

        } else {
            vp_sign.currentItem = vp_sign.currentItem + 1
            when (vp_sign.currentItem) {
                1 -> {
                    email = adapter.items[0].ed_email.text.toString()
                }
                2 -> {
                    pw = adapter.items[1].ed_sign_up_pw.text.toString()
                }


            }
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