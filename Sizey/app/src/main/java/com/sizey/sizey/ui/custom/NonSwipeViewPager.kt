package com.sizey.sizey.ui.custom

import android.content.Context
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NonSwipeViewPager(context:Context) :ViewPager(context){
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}