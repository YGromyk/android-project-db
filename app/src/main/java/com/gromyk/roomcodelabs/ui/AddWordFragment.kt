package com.gromyk.roomcodelabs.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.WordViewModel
import com.gromyk.roomcodelabs.model.DBWord
import com.gromyk.roomcodelabs.ui.base.BaseFragment
import kotlinx.android.synthetic.main.add_word_layout.*

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */

class AddWordFragment : BaseFragment() {
    companion object {
        fun newInstance() = AddWordFragment()
    }

    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_word_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        addWordButton.setOnClickListener {
            if (wordEditText.text.toString().isNotBlank()) {
                wordEditText.error = null
                viewModel.insert(DBWord(word = wordEditText.text.toString()))
                findNavController().navigateUp()
            } else {
                wordEditText.error = "text cannot be empty!"
            }
        }
    }
}