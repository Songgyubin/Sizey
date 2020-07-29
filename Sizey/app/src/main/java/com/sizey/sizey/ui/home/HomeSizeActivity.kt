package com.sizey.sizey.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sizey.sizey.R
import kotlinx.android.synthetic.main.activity_home_size.*

class HomeSizeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_size)
        recycler_category.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }




    }
}