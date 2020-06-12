package com.example.dogid.ui.util

import androidx.core.util.PatternsCompat

fun emailValidator(email: String): Boolean {
    return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
}