package com.sizey.sizey

import android.app.Application
import com.kakao.auth.KakaoSDK
import com.sizey.sizey.util.KakaoSDKAdapter

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this
        KakaoSDK.init(KakaoSDKAdapter())
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }
    fun getMyApplicationContext():MyApplication{
        checkNotNull(instance){
            "this application does not inherit com.kakao.GlobalApplication"
        }
        return instance!!
    }

    companion object {
        private const val TAG = "MyApplication.kt"
        var instance: MyApplication? = null
    }
}