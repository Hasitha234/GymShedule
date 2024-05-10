package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

        submit.setOnClickListener {
            submit()
        }
    }
    fun submit(){
        Toast.makeText(this,"Your Schedule added",Toast.LENGTH_LONG).show()
    }
}