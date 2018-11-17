package com.gromyk.roomcodelabs.ui.base

import android.support.v4.app.Fragment
import com.gromyk.roomcodelabs.R

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */

abstract class BaseFragment : Fragment() {
    fun openFragment(baseFragment: BaseFragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.rootView, baseFragment)
            ?.commitNow()
    }

    fun addToBackStack(baseFragment: BaseFragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.rootView, baseFragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}