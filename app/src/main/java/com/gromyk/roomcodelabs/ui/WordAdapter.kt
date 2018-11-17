package com.gromyk.roomcodelabs.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gromyk.roomcodelabs.R
import com.gromyk.roomcodelabs.model.DBWord

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */

class WordAdapter : RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    var items: List<DBWord> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word_item_layout, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = items[position].word
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView by lazy { itemView.findViewById<TextView>(R.id.textView) }
    }
}