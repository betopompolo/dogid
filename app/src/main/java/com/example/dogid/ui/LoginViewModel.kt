package com.example.dogid.ui

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.*
import com.example.dogid.R
import com.example.dogid.data.*


class LoginViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    var authUser = AuthUser()
        set(value) {
            field = value
            validateForm()
        }

    val isLoginFormValid: LiveData<Boolean>
        get() = _isLoginFormValid
    private val _isLoginFormValid = MutableLiveData(false)

    val loggedUser: LiveData<User>
        get() = _loggedUser
    private val _loggedUser = MutableLiveData<User>()

    val loginError: LiveData<Error>
        get() = _loginError
    private val _loginError = MutableLiveData<Error>()

    private val userRepository = UserRepository()

    fun login() {
        userRepository.login(authUser, object : RepositoryCallback<User> {
            override fun onSuccess(data: User) {
                userRepository.saveLoggedUser(data, getApplication())
                _loggedUser.postValue(data)
            }

            override fun onError(error: Error?) {
                val errorMsg = getApplication<Application>().getString(R.string.defaultErrorMessage)
                _loginError.postValue(Error(errorMsg))
            }

        })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onResume() {
        if (loggedUser.value == null) {
            userRepository.getLoggedUser(getApplication())?.let { user ->
                _loggedUser.postValue(user)
            }
        }
    }

    private fun validateForm() {
        val isUserEmailValid = emailValidator(authUser.email)
        _isLoginFormValid.postValue(isUserEmailValid)
    }
}