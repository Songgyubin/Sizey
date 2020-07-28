package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R

class SignUpHeightWeightFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup_heightweight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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