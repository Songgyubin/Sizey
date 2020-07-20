package com.sizey.sizey.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sizey.sizey.R

class EmailFragment : Fragment(){

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