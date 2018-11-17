package com.gromyk.roomcodelabs.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.ui.base.BaseFragment
import kotlinx.android.synthetic.main.sign_in_fragment.*

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */

class SignInFragment : BaseFragment() {
    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sign_in_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_wordsListFragment)
        }
    }
}