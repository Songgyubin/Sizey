package com.songgyubin.sizey

import android.app.Application
import com.songgyubin.sizey.etc.koin.myDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@MyApplication)
            modules(myDiModule)
        }
    }

    companion object{
        private const val TAG = "MyApplication.kt"

        private var instance: MyApplication? = null
        fun getInstance(): MyApplication {
            if (instance == null) {
                instance = MyApplication()
            }

            return instance!!
        }
    }
}
