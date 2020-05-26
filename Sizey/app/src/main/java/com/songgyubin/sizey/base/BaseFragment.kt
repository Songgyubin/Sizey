package com.songgyubin.sizey.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment <V: ViewModel, T: ViewDataBinding>:Fragment(){


    lateinit var viewDataBinding: T
    abstract val viewModel : V
    abstract val layResourceId: Int

    abstract fun setView(view: View?, savedInstanceState: Bundle?, arguments: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layResourceId, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView(view, savedInstanceState, arguments)

    }
}