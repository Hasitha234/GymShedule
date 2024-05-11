package com.example.gymapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapp.models.Post
import java.text.SimpleDateFormat
import java.util.Locale

class MyDataAdapter(private val data:List<Post>): RecyclerView.Adapter<MyDataVH>() {
    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataVH {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)

        val view:View = layoutInflater.inflate(R.layout.activity_main1, parent,false)

        return MyDataVH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyDataVH, position: Int) {
        val singleData = data[position]

        val toggle = true

        holder.exercise1.text = singleData.exercise
        holder.day1.text = singleData.days.toString()
        holder.date1.text = dateFormatter.format(singleData.date)
    }
}