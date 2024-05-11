package com.example.gymapp

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyDataVH(itemView: View): RecyclerView.ViewHolder(itemView) {
    val exercise1:TextView = itemView.findViewById(R.id.exrcise1)
    val day1:TextView = itemView.findViewById(R.id.day1)
    val date1:TextView = itemView.findViewById(R.id.date1)
}