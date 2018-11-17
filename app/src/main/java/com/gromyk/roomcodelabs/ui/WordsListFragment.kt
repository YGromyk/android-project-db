package com.gromyk.roomcodelabs.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.WordViewModel
import com.gromyk.roomcodelabs.model.DBWord
import com.gromyk.roomcodelabs.ui.base.BaseFragment
import kotlinx.android.synthetic.main.words_fragment.*

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */


class WordsListFragment : BaseFragment() {

    private lateinit var viewModel: WordViewModel
    private val adapter: WordAdapter by lazy { WordAdapter() }

    companion object {
        fun newInstance() = WordsListFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.words_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        viewModel.apply {
            allWords.observe(this@WordsListFragment, Observer { onWordsChanged(it) })
        }
    }

    private fun onWordsChanged(list: MutableList<DBWord>?) {
        list?.let {
            adapter.items = it
            recyclerView.adapter = adapter
        }
    }

    private fun initView() {
        initRecycler()
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_wordsListFragment_to_addWordFragment2)
        }
    }

    private fun initRecycler() {
        activity?.let {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(it)
        }
    }

}