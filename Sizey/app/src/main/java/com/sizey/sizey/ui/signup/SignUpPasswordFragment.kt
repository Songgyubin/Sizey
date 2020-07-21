package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R
import com.sizey.sizey.util.PASSWORD
import com.sizey.sizey.util.PASSWORD_CHECK
import com.sizey.sizey.util.check
import kotlinx.android.synthetic.main.fragment_signup_password.*

class SignUpPasswordFragment : Fragment() {

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
        ed_sign_up_pw.check("6자리 이상 입력하세요", tv_sign_up_pw_warning, PASSWORD, null)
        ed_sign_up_pw_check.check(
            "비밀번호가 다릅니다",
            tv_sign_up_pw_check_warning,
            PASSWORD_CHECK,
            ed_sign_up_pw
        )
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