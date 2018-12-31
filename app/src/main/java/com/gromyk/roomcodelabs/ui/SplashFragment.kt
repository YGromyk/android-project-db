package com.gromyk.roomcodelabs.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.ui.base.BaseFragment

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */

class SplashFragment : BaseFragment() {
    companion object {
        fun newInstance() = SplashFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startLoginScreen()
    }

    private fun startLoginScreen() {
        Handler().postDelayed(
            { findNavController().navigate(R.id.action_splashFragment_to_authFragment) },
            2000
        )
    }
}