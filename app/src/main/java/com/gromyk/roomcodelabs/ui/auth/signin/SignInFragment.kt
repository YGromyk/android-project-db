package com.gromyk.roomcodelabs.ui.auth.signin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gromyk.api.auth.entities.AccessTokenDTO
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.ui.base.BaseFragment
import com.gromyk.roomcodelabs.ui.main.AuthData
import kotlinx.android.synthetic.main.sign_in_fragment.*

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */

class SignInFragment : BaseFragment() {
    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        getArgumentsData()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        viewModel.signInData.observe(this, Observer { onSignDataReceived(it) })
    }

    private fun onSignDataReceived(accessToken: AccessTokenDTO?) {
        accessToken?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sign_in_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInButton.setOnClickListener {
            //findNavController().navigate(R.id.action_signInFragment_to_wordsListFragment)
            startOAuth()
        }
    }

    private fun getArgumentsData() {
        val code = arguments?.getString(getString(R.string.oAuthCode))
        code?.let {
            if (it.isNotBlank() || it.isNotEmpty())
                viewModel.getAccessToken(code)
        }
    }

    private fun startOAuth() {
        val uri = AuthData.uri
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


}