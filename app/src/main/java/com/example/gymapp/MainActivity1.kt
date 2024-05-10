package com.example.gymapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.Calendar

class MainActivity1 : AppCompatActivity() {

    lateinit var exercise:EditText
    lateinit var days:EditText
    lateinit var date:EditText
    lateinit var submit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        exercise = findViewById(R.id.exercise)
        days =findViewById(R.id.days)
        date = findViewById(R.id.date)
        submit = findViewById(R.id.submit)

        date = findViewById(R.id.date)

        // Setting up the DatePickerDialog
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Display the selected date in the EditText
                    val selectedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
                    date.setText(selectedDate)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        submit.setOnClickListener {
            submit()
        }
    }
    fun submit(){
        Toast.makeText(this,"Your Schedule added",Toast.LENGTH_LONG).show()
    }
}