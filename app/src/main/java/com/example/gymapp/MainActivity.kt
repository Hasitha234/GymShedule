package com.example.gymapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var schedule: Button
    private lateinit var view: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the buttons with their corresponding IDs
        schedule = findViewById(R.id.schedule)
        view = findViewById(R.id.view)

        // Listener for the 'schedule' button
        schedule.setOnClickListener {
            // Navigate to MainActivity1
            val intent = Intent(baseContext, MainActivity1::class.java)
            startActivity(intent)

            // Additional logic for scheduling
            createSchedule()
        }

        // Listener for the 'view' button
        view.setOnClickListener {
            // Navigate to MainActivity2
            val intent = Intent(baseContext, MainActivity2::class.java)
            startActivity(intent)

            // Additional logic for viewing schedules
            viewSchedule()
        }
    }

    fun createSchedule() {
        // Logic for creating a schedule (if any)
    }

    fun viewSchedule() {
        // Logic for viewing schedules (if any)
    }
}
