package com.sizey.sizey.ui.setting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sizey.sizey.R
import kotlinx.android.synthetic.main.toolbar_none_logo.*

class SettingActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        tv_toolbar_none_logo.text= "설정"
        btn_toolbar_none_logo.visibility = View.GONE

    }
}