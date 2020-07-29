package com.sizey.sizey.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R
import com.sizey.sizey.listener.GenderButtonListener
import com.sizey.sizey.util.NICK
import com.sizey.sizey.util.check
import kotlinx.android.synthetic.main.fragment_signup_gendernick.*

class SignUpGenderNickFragment : Fragment(R.layout.fragment_signup_gendernick) {

    var gender = "성별"
    private var genderListener: GenderButtonListener? = null

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
            Log.d(TAG, ": 남자")
            btn_gender_man.setBackgroundResource(R.drawable.selected_btn)
            btn_gender_woman.setBackgroundResource(R.drawable.unselected_btn)
            genderListener!!.selectGender("남자")
        }
        btn_gender_woman.setOnClickListener {
            Log.d(TAG, ": 여자")
            btn_gender_woman.setBackgroundResource(R.drawable.selected_btn)
            btn_gender_man.setBackgroundResource(R.drawable.unselected_btn)
            genderListener!!.selectGender("여자")
        }
    }

    fun setGenderListener(genderButtonListener: GenderButtonListener) {
        this.genderListener = genderButtonListener
    }
    companion object {
        private const val TAG = "SexNickFragment.kt"
    }
}