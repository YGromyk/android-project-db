package com.gromyk.roomcodelabs.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.ui.base.BaseFragment
import kotlinx.android.synthetic.main.sign_up_fragment.*

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */

class SignUpFragment: BaseFragment() {
    companion object {
        fun newInstance() = SignUpFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        haveAccountTextView.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
}