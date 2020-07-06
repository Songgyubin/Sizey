package com.sizey.sizey.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sizey.sizey.R
import kotlinx.android.synthetic.main.page_tutorial.*

class TutorialFragment : Fragment() {

    var view_id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        view_id = args!!.getInt("R_id")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.page_tutorial, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        when (view_id) {
            0 -> iv_tutorial.setImageResource(R.drawable.tmpimg)
            1 -> iv_tutorial.setImageResource(R.drawable.tmpimg)
            2 -> iv_tutorial.setImageResource(R.drawable.tmpimg)
            3 -> iv_tutorial.setImageResource(R.drawable.tmpimg)
            4 -> iv_tutorial.setImageResource(R.drawable.tmpimg)
        }
    }
}