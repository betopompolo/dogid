package com.example.dogid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    var userEmail = ""
        set(value) {
            field = value
            validateForm()
        }

    private val _isLoginFormValid = MutableLiveData(false)
    val isLoginFormValid: LiveData<Boolean>
        get() = _isLoginFormValid

    fun validateForm() {
        val isUserEmailValid = emailValidator(userEmail)
        _isLoginFormValid.postValue(isUserEmailValid)
    }
}