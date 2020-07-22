package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R
import com.sizey.sizey.util.NICK
import com.sizey.sizey.util.check
import kotlinx.android.synthetic.main.fragment_signup_gendernick.*

class GenderNickFragment : Fragment(R.layout.fragment_signup_gendernick) {

    var gender = "성별"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup_gendernick, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ed_nick.check("2자 이상 입력하세요", tv_nick_warning, NICK, null)


        btn_gender_man.setOnClickListener {
            btn_gender_man.setBackgroundResource(R.drawable.selected_btn)
            btn_gender_woman.setBackgroundResource(R.drawable.unselected_btn)
            gender = "남자"
        }
        btn_gender_woman.setOnClickListener {
            btn_gender_woman.setBackgroundResource(R.drawable.selected_btn)
            btn_gender_man.setBackgroundResource(R.drawable.unselected_btn)
            gender = "여자"
        }

    }

    companion object {
        private const val TAG = "SexNickFragment.kt"
    }
}