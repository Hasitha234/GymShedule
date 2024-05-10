package com.example.gymapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.privacysandbox.tools.core.validator.ValidationResult
import com.example.gymapp.models.FormData
import com.example.gymapp.models.validation.validationResuls
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class MainActivity1 : AppCompatActivity() {

    private lateinit var exercise: EditText
    private lateinit var days: EditText
    private lateinit var date: EditText
    private lateinit var submit: Button

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        exercise = findViewById(R.id.exercise)
        days = findViewById(R.id.days)
        date = findViewById(R.id.date)
        submit = findViewById(R.id.submit)

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

    // Display an alert dialog
    private fun displayAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }

    // Process form submission
    private fun submit(v: View) {
        val daysValue = days.text.toString().toIntOrNull()
        if (daysValue == null) {
            displayAlert("Invalid Input", "Please enter a valid number for days")
            return
        }

        // Parsing the date
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dateValue: Date? = try {
            dateFormat.parse(date.text.toString())
        } catch (e: ParseException) {
            null
        }

        if (dateValue == null) {
            displayAlert("Invalid Input", "Please enter a valid date")
            return
        }

        val myForm = FormData(
            exercise.text.toString(),
            daysValue,
            dateValue
        )

        // Example validation methods in the `FormData` model
        val exerciseValidation = myForm.validateExersice()

        when(exerciseValidation){
            is validationResuls.Valid ->{
                count++
            }
            is validationResuls.Invalid ->{
                exercise.error = exerciseValidation.errorMessage
            }
            is validationResuls.Empty ->
            {
                exercise.error = exerciseValidation.errorMessage
            }

        }
        if(count == 1){
            displayAlert("Success","You have successfully Registered")
        }else{
            count = 0
        }
    }

    // Simple form submission confirmation message
    private fun submit() {
        Toast.makeText(this, "Your Schedule added", Toast.LENGTH_LONG).show()
    }
}
