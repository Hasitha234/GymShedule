package com.example.gymapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapp.R
import com.example.gymapp.models.TaskListModel

class TaskListAdapter(internal var context: Context, var tasklist: List<TaskListModel>)
    : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var exercise: TextView = view.findViewById(R.id.exercise)
        var days: TextView = view.findViewById(R.id.days)
        var date: TextView = view.findViewById(R.id.date)
        var btn_edit: Button = view.findViewById(R.id.update1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        // Make sure to use the correct layout here for the items, not the activity layout
        val view = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasklist.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tasks = tasklist[position]
        holder.exercise.text = tasks.exercise
        holder.days.text = tasks.days.toString()
        holder.date.text = tasks.date
    }
}
