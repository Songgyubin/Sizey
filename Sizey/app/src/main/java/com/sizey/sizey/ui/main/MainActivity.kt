package com.sizey.sizey.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.auth.AuthType
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.exception.KakaoException
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import com.sizey.sizey.R
import com.sizey.sizey.ui.adapter.BottomDotAdapter
import com.sizey.sizey.ui.custom.ZoomOutPageTransformer
import com.sizey.sizey.ui.login.SignActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {


    // kakao
    private lateinit var kakaoCallback: SessionCallback
    private lateinit var kakaoSession: Session

    // naver
    private lateinit var naverInstance: OAuthLogin
    private lateinit var naverHandler: OAuthLoginHandler

    private var backKeyPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Tutorial viewPager & indicator
        viewpager_main.adapter = BottomDotAdapter(supportFragmentManager)
        viewpager_main.currentItem = 0
        viewpager_main.setPageTransformer(
            true,
            ZoomOutPageTransformer()
        )
        tablayout_main.setupWithViewPager(viewpager_main, true)
        // end

        btn_kakao_start.setOnClickListener { kakaoLogin() }



        naverHandler = @SuppressLint("HandlerLeak")
        object : OAuthLoginHandler() {
            override fun run(p0: Boolean) {
                if (p0) {
                    var accessToken = naverInstance.getAccessToken(this@MainActivity)
                    var refreshToken = naverInstance.getRefreshToken(this@MainActivity)
                    var expiresAt = naverInstance.getExpiresAt(this@MainActivity)
                    var tokenType = naverInstance.getTokenType(this@MainActivity)
                    toast("로그인 성공")
                } else {
                    var errorCode = naverInstance.getLastErrorCode(this@MainActivity).code
                    var errorDesc = naverInstance.getLastErrorDesc(this@MainActivity)
                    toast("$errorCode $errorCode")
                }
            }

        }

        btn_naver_start.setOAuthLoginHandler(naverHandler)
        btn_naver_start.setOnClickListener { naverLogin() }
        btn_email_start.setOnClickListener { firebaseLogin() }
    }

    private fun firebaseLogin() {
        startActivity<SignActivity>()
    }

    private fun naverLogin() {

        naverInstance = OAuthLogin.getInstance()
        naverInstance.showDevelopersLog(true)
        naverInstance.init(this, NAVER_CLIENT_ID, NAVER_CLIENT_SECRET, NAVER_CLIENT_NAME)
        naverInstance.startOauthLoginActivity(this, naverHandler)
    }

    private fun kakaoLogin() {
        // kakao init
        kakaoCallback = SessionCallback()
        kakaoSession = Session.getCurrentSession()
        kakaoSession.addCallback(kakaoCallback)
        kakaoSession.checkAndImplicitOpen()
        //end
        kakaoSession.open(AuthType.KAKAO_LOGIN_ALL, this)

    }


    private inner class SessionCallback : ISessionCallback {
        override fun onSessionOpened() {
            // 로그인 세션이 열렸을 때
            UserManagement.getInstance().me(object : MeV2ResponseCallback() {
                override fun onSuccess(result: MeV2Response?) {
                    // 로그인이 성공했을 때
                    /*var intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("name", result!!.getNickname())
                    intent.putExtra("profile", result!!.getProfileImagePath())
                    startActivity(intent)
                    finish()*/
                    toast("카카오 로그인 성공")
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


    override fun onResume() {
        Log.d("TAG", ": onResume")
        super.onResume()

    }

    override fun onStop() {
        Log.d("TAG", ": onStop")
        super.onStop()

    }

    override fun onStart() {
        Log.d("TAG", ": onStart")
        super.onStart()

    }

    override fun onDestroy() {
        Log.d("TAG", ": onDestroy")
        super.onDestroy()

    }

    companion object {
        private const val TAG = "MainActivity.kt"
        private const val NAVER_CLIENT_ID = "hoKFoPP88o6CS80Hz1fQ"
        private const val NAVER_CLIENT_SECRET = "Q8eRAuTjHM"
        private const val NAVER_CLIENT_NAME = "네이버 아이디로 로그인"
    }

    override fun onBackPressed() {

        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast("뒤로 버튼을 한번 더 누르시면 종료됩니다.")
            return
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
        }
    }
}