package com.example.dogid

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.dogid.data.model.AuthUser
import com.example.dogid.ui.viewmodel.LoginViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verifyOrder
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel

    @RelaxedMockK
    lateinit var mockObserver: Observer<Boolean>

    @RelaxedMockK
    lateinit var mockApp: Application

    @Before
    fun beforeTests() {
        MockKAnnotations.init(this)
        viewModel = LoginViewModel(mockApp)
    }

    @After
    fun afterTests() {
        viewModel.isLoginFormValid.removeObserver(mockObserver)
    }

    @Test
    fun testLoginFormValidation() {
        viewModel.isLoginFormValid.observeForever(mockObserver)

        viewModel.authUser = AuthUser("test@")
        viewModel.authUser =
            AuthUser("test@gmail.com")
        viewModel.authUser = AuthUser("test.com")
        viewModel.authUser =
            AuthUser("test@gmail.com.br")

        verifyOrder {
            mockObserver.onChanged(false)
            mockObserver.onChanged(true)
            mockObserver.onChanged(false)
            mockObserver.onChanged(true)
        }

    }
}