package com.example.dogid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.dogid.R
import com.example.dogid.data.model.AuthUser
import com.example.dogid.data.model.User
import com.example.dogid.data.repository.RepositoryCallback
import com.example.dogid.data.repository.UserRepository
import com.example.dogid.ui.util.emailValidator


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

    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _isLoading = MutableLiveData(false)

    private val userRepository =
        UserRepository()

    fun login() {
        _isLoading.postValue(true)
        userRepository.login(authUser, object :
            RepositoryCallback<User> {
            override fun onSuccess(data: User) {
                _isLoading.postValue(false)
                userRepository.saveLoggedUser(data, getApplication())
                _loggedUser.postValue(data)
            }

            override fun onError(error: Error?) {
                _isLoading.postValue(false)
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
        val isUserEmailValid =
            emailValidator(authUser.email)
        _isLoginFormValid.postValue(isUserEmailValid)
    }
}