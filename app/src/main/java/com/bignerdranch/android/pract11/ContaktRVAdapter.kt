package com.bignerdranch.android.pract11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContaktRVAdapter(context: Context, val data: MutableList<Book>) : RecyclerView.Adapter<ContaktHolder?>() {

    private  val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaktHolder {
        val view: View = layoutInflater.inflate(R.layout.item_kniga, parent, false)
        return ContaktHolder(view)
    }

    override fun onBindViewHolder(holder: ContaktHolder, position: Int) {
        val item = data[position]
        holder.nameTextView.text = item.name
        holder.authorTextView.text = item.author
        holder.pagesTextView.text = item.pages
    }

    override fun getItemCount(): Int = data.size

}