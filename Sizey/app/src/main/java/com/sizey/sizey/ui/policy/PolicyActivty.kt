package com.sizey.sizey.ui.policy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sizey.sizey.R
import kotlinx.android.synthetic.main.toolbar_none_logo.*

class PolicyActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy)
        tv_toolbar_none_logo.text = "이용약관"
    }
}