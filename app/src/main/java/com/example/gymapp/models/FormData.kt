package com.example.gymapp.models

import com.example.gymapp.models.validation.validationResuls
import java.util.Date

class FormData (
    private var exercise:String,
    private var days:Int,
    private var date:Date,
)
{
    fun validateExersice():validationResuls{
        return if (exercise.isEmpty()){
            validationResuls.Empty("Enter the exercises")
        }else{
            validationResuls.Valid
        }
    }

}


