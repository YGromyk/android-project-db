package com.gromyk.roomcodelabs.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.WordViewModel
import com.gromyk.roomcodelabs.model.DBWord
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: WordViewModel
    private lateinit var adapter: WordAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initRecycler()

        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.rootView, AddWordFragment.newInstance())
                .addToBackStack(AddWordFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun initRecycler() {
        adapter = WordAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        viewModel.apply {
            allWords.observe(this@MainActivity, Observer { onWordsChanged(it) })
        }
    }

    private fun onWordsChanged(list: MutableList<DBWord>?) {
        list?.let {
            adapter.items = it
            recyclerView.adapter = adapter
        }
    }
}
