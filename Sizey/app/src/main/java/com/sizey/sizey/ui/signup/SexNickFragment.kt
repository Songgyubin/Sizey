package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R
import com.sizey.sizey.util.NICK
import com.sizey.sizey.util.check
import kotlinx.android.synthetic.main.fragment_signup_sexnick.*

class SexNickFragment : Fragment(R.layout.fragment_signup_sexnick) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup_sexnick, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ed_nick.check("2자 이상 입력하세요", tv_nick_warning, NICK, null)
    }

    companion object {
        private const val TAG = "SexNickFragment.kt"
    }
}