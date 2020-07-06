package com.sizey.sizey.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sizey.sizey.R
import com.sizey.sizey.ui.adapter.BottomDotAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Tutorial viewPager & indicator
        viewpager_main.adapter = BottomDotAdapter(supportFragmentManager)
        viewpager_main.currentItem = 0

        tablayout_main.setupWithViewPager(viewpager_main, true)


    }

}