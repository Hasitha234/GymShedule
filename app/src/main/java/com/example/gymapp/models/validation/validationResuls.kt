package com.example.gymapp.models.validation

import android.webkit.ConsoleMessage

sealed class validationResuls {
    data class Empty(val errorMessage: String):validationResuls()
    data class Invalid(val errorMessage: String):validationResuls()
    object Valid:validationResuls()
}