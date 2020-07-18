package com.sizey.sizey.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R

class SexNickFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, ": onCreateView")
        return inflater.inflate(R.layout.fragment_signup_sexnick, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, ": onViewCreated")
    }

    companion object {
        private const val TAG = "SexNickFragment.kt"
    }
}