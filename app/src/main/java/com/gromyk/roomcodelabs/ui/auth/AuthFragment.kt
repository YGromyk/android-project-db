package com.gromyk.roomcodelabs.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.ui.base.BaseFragment
import kotlinx.android.synthetic.main.auth_fragment.*

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */


class AuthFragment : BaseFragment() {
    companion object {
        fun newInstance() = AuthFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.auth_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() {
        registerButton.setOnClickListener { startRegisterScreen() }
        loginButton.setOnClickListener { startLoginScreen() }
    }

    private fun startLoginScreen() {
        findNavController().navigate(R.id.action_authFragment_to_signInFragment)
    }

    private fun startRegisterScreen() {
        findNavController().navigate(R.id.action_authFragment_to_signUpFragment)
    }
}