package com.sizey.sizey.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.sizey.sizey.R
import kotlinx.android.synthetic.main.fragment_signup_password.*

class PasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, ": onCreateView")
        return inflater.inflate(R.layout.fragment_signup_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, ": onViewCreated")
        setFragmentResultListener("test"){ key, bundle->
            val s = bundle.getString("id")
            ed_sign_up_pw.hint = s
        }
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
        private const val TAG = "PasswordFragment.kt"
    }
}