package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var update1:Button
    lateinit var delete:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        update1 = findViewById(R.id.update1)
        delete = findViewById(R.id.delete)

        update1.setOnClickListener {

        }
    }
    fun update(){
        Toast.makeText(this,"Your Schedule is updated",Toast.LENGTH_LONG).show()
    }
}