package com.songgyubin.sizey.etc.extension

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

// fragment 변경
fun FragmentActivity.replaceFragment(@IdRes res: Int, fragment: Fragment, tag: String? = null) {
    val fragmentTransaction: FragmentTransaction = this.supportFragmentManager.beginTransaction()
    if (tag != null) {
        fragmentTransaction.replace(res, fragment, tag)
    } else {
        fragmentTransaction.replace(res, fragment)
    }
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
//    fragmentTransaction.commitAllowingStateLoss()
}

fun setToolbar(my_toolbar: Toolbar, appCompatActivity: AppCompatActivity) {
    appCompatActivity.setSupportActionBar(my_toolbar)

    appCompatActivity.supportActionBar?.setDisplayShowTitleEnabled(false)
    my_toolbar.setContentInsetsRelative(0, 0)
}