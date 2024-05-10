package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var schedule:Button
    lateinit var view:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        schedule = findViewById(R.id.schedule)
        view = findViewById(R.id.view)

        schedule.setOnClickListener {
            createSchedule()
        }

        view.setOnClickListener {
            viewSchedule()
        }
    }

    fun createSchedule(){

    }

    fun viewSchedule(){

    }
}