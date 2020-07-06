package com.sizey.sizey.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sizey.sizey.ui.tutorial.TutorialFragment

class BottomDotAdapter(val fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        val bundle: Bundle
        var cur_fragment: Fragment = TutorialFragment()
        if (position in 0 until MAX_PAGE) {

            when (position) {
                0 -> {
                    bundle = Bundle()
                    bundle.putInt("R_id", position)
                    cur_fragment = TutorialFragment()
                    cur_fragment.arguments = bundle

                }

                1 -> {
                    bundle = Bundle()
                    bundle.putInt("R_id", position)
                    cur_fragment = TutorialFragment()
                    cur_fragment.arguments = bundle

                }
                2 -> {
                    bundle = Bundle()
                    bundle.putInt("R_id", position)
                    cur_fragment = TutorialFragment()
                    cur_fragment.arguments = bundle

                }
                3 -> {
                    bundle = Bundle()
                    bundle.putInt("R_id", position)
                    cur_fragment = TutorialFragment()
                    cur_fragment.arguments = bundle

                }

            }


        }

        return cur_fragment
    }

    override fun getCount(): Int {
        return MAX_PAGE
    }

    companion object {
        private const val TAG = "BottomDotAdapter.kt"
        private const val MAX_PAGE = 5
    }
}