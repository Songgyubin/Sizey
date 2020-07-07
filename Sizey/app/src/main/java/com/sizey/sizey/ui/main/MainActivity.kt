package com.sizey.sizey.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport
import com.kakao.auth.AuthType
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.exception.KakaoException
import com.sizey.sizey.R
import com.sizey.sizey.ui.adapter.BottomDotAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {

    private lateinit var callback:SessionCallback
    private lateinit var session: Session
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Tutorial viewPager & indicator
        viewpager_main.adapter = BottomDotAdapter(supportFragmentManager)
        viewpager_main.currentItem = 0

        tablayout_main.setupWithViewPager(viewpager_main, true)
        // end
        btn_kakao_start.setOnClickListener { kakaoLogin() }



    }

    private fun kakaoLogin(){
        // kakao init
        callback = SessionCallback()
        session = Session.getCurrentSession()
        session.addCallback(callback)
        session.checkAndImplicitOpen()
        //end
        session.open(AuthType.KAKAO_LOGIN_ALL,this)
    }

    private inner class SessionCallback : ISessionCallback {
        override fun onSessionOpened() {
            // 로그인 세션이 열렸을 때
            UserManagement.getInstance().me( object : MeV2ResponseCallback() {
                override fun onSuccess(result: MeV2Response?) {
                    // 로그인이 성공했을 때
                    /*var intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("name", result!!.getNickname())
                    intent.putExtra("profile", result!!.getProfileImagePath())
                    startActivity(intent)
                    finish()*/
                    Log.d(TAG, "$result: 카카오 로그인 성공")
                }

                override fun onSessionClosed(errorResult: ErrorResult?) {
                    // 로그인 도중 세션이 비정상적인 이유로 닫혔을 때
                    /*Toast.makeText(
                        this@LoginActivity,
                        "세션이 닫혔습니다. 다시 시도해주세요 : ${errorResult.toString()}",
                        Toast.LENGTH_SHORT).show()*/
                    Log.d(TAG, "${errorResult.toString()}: 카카오 로그인 실패")
                }
            })
        }
        override fun onSessionOpenFailed(exception: KakaoException?) {
            // 로그인 세션이 정상적으로 열리지 않았을 때
            if (exception != null) {
                /*com.kakao.util.helper.log.Logger.e(exception)
                Toast.makeText(
                    this@LoginActivity,
                    "로그인 도중 오류가 발생했습니다. 인터넷 연결을 확인해주세요 : $exception",
                    Toast.LENGTH_SHORT).show()*/
            }
        }

    }
    companion object{
    private const val TAG = "MainActivity.kt"
    }

}