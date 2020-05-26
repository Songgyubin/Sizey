package com.songgyubin.sizey.ui

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.songgyubin.sizey.MainActivity
import com.songgyubin.sizey.R
import org.jetbrains.anko.startActivity

class SplashActivity :Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(SplashHandler(),3000)
    }
    inner class SplashHandler: Runnable{
        override fun run() {

            startActivity<MainActivity>()
            SplashActivity().finish()
        }

    }

    override fun onBackPressed() {

    }
    companion object{
        private const val TAG = "SplashActivity.kt"
    }
}