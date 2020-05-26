package com.songgyubin.sizey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.songgyubin.sizey.etc.extension.setToolbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.appcompat.v7.titleResource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
