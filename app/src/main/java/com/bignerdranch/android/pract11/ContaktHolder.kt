package com.bignerdranch.android.pract11

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ContaktHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var nameTextView: TextView = itemView.findViewById(R.id.tvName)
    var authorTextView: TextView = itemView.findViewById(R.id.tvAuthor)
    var pagesTextView: TextView = itemView.findViewById(R.id.tvKolvostranic)
}