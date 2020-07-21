package com.sizey.sizey.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.sizey.sizey.R

val PASSWORD = 0
val PASSWORD_CHECK = 1
val NICK = 2
val EMAIL = 3


fun EditText.checkEamil(message: String, tv: TextView) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                tv.text = message
                this@checkEamil.setBackgroundResource(R.drawable.red_ed)
            } else {
                tv.text = ""
                this@checkEamil.setBackgroundResource(R.drawable.white_ed)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}

fun EditText.check(message: String, tv: TextView, flag: Int, ed: EditText?) {

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            when (flag) {
                PASSWORD -> {
                    if (this@check.text.toString().length < 6) {
                        tv.text = message
                        this@check.setBackgroundResource(R.drawable.red_ed)
                    } else {
                        tv.text = ""
                        this@check.setBackgroundResource(R.drawable.white_ed)
                    }
                }

                PASSWORD_CHECK -> {
                    if (this@check.text.toString() != ed!!.text.toString()) {
                        tv.text = message
                        this@check.setBackgroundResource(R.drawable.red_ed)
                    } else {
                        tv.text = ""
                        this@check.setBackgroundResource(R.drawable.white_ed)
                    }
                }
                NICK -> {
                    if (this@check.text.toString().length < 2) {
                        tv.text = message
                        this@check.setBackgroundResource(R.drawable.red_ed)
                    } else {
                        tv.text = ""
                        this@check.setBackgroundResource(R.drawable.white_ed)
                    }
                }
                EMAIL -> {
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                        tv.text = message
                        this@check.setBackgroundResource(R.drawable.red_ed)
                    } else {
                        tv.text = ""
                        this@check.setBackgroundResource(R.drawable.white_ed)
                    }
                }


            }

        }

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })

}