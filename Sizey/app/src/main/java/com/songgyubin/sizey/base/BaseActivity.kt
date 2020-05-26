package com.songgyubin.sizey.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<V : ViewModel, T : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewDataBinding: T
    abstract val viewModel: V
    abstract val layResourceId: Int

    abstract fun initStartView()

    abstract fun initEtc()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layResourceId)
        viewDataBinding.lifecycleOwner = this

        initStartView()
        initEtc()

    }
}