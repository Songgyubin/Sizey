package com.sizey.sizey.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sizey.sizey.R
import com.sizey.sizey.ui.adapter.SignPagerAdapter
import kotlinx.android.synthetic.main.activity_login.*

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
        vp_sign.offscreenPageLimit = 3
        adapter = SignPagerAdapter(supportFragmentManager)
        adapter.addItem(EmailFragment())
        adapter.addItem(PasswordFragment())
        adapter.addItem(SexNickFragment())

        vp_sign.adapter = adapter


//        firebaseAuth = FirebaseAuth.getInstance()

//        btn_next.setOnClickListener { firebaseLogin() }
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
        if(vp_sign.currentItem ==0  ){

            super.onBackPressed()
        }
        else{
            vp_sign.currentItem = vp_sign.currentItem-1
        }

    }
}