package com.example.gymapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapp.adapter.TaskListAdapter
import com.example.gymapp.database.DatabaseHelper
import com.example.gymapp.models.TaskListModel

class MainActivity : AppCompatActivity() {

    lateinit var recycler_task: RecyclerView
    lateinit var schedule: Button
    var taskListAdapter: TaskListAdapter? = null
    lateinit var dbHandler: DatabaseHelper  // Correct type for dbHandler
    lateinit var linearLayoutManager: LinearLayoutManager
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_task = findViewById(R.id.rv_list)
        schedule = findViewById(R.id.schedule)

        dbHandler = DatabaseHelper(this)  // Correct initialization of DatabaseHelper
        fetchlist()

        schedule.setOnClickListener {
            val i = Intent(applicationContext, MainActivity1::class.java)
            startActivity(i)
        }
    }

    private fun fetchlist() {
        val tasklist = dbHandler.getAllTask()  // Correct method call and declaration of tasklist
        taskListAdapter = TaskListAdapter(applicationContext, tasklist)  // Correct adapter initialization
        linearLayoutManager = LinearLayoutManager(applicationContext)
        recycler_task.layoutManager = linearLayoutManager
        recycler_task.adapter = taskListAdapter
        taskListAdapter?.notifyDataSetChanged()  // Correct method call with safe call operator
    }

}
