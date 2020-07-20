package com.sizey.sizey.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R
import com.sizey.sizey.listener.ViewPagerListener
import kotlinx.android.synthetic.main.fragment_email.*

class EmailFragment : Fragment() {

     private var viewPagerListener: ViewPagerListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, ": onCrateView")

        return inflater.inflate(R.layout.fragment_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, ": onViewCreated")
        /*btn_next.setOnClickListener {
            *//*LoginActivity().nextPage()
            viewPagerListener!!.nextPage(1)*//*
        }*/
    }

    fun setDialogListener(viewPagerListener: ViewPagerListener) {
        this.viewPagerListener = viewPagerListener
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, ": onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, ": onDestrotyView")
    }

    companion object {
        private const val TAG = "EmailFragment.kt"
    }

}