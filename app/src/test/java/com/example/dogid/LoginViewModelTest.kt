package com.example.dogid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.dogid.ui.LoginViewModel
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

    lateinit var viewModel: LoginViewModel

    @RelaxedMockK
    lateinit var mockObserver: Observer<Boolean>

    @Before
    fun beforeTests() {
        MockKAnnotations.init(this)
        viewModel = LoginViewModel()
    }

    @After
    fun afterTests() {
        viewModel.isLoginFormValid.removeObserver(mockObserver)
    }

    @Test
    fun testLoginFormValidation() {
        viewModel.isLoginFormValid.observeForever(mockObserver)

        viewModel.userEmail = "test@"
        viewModel.userEmail = "test@gmail.com"
        viewModel.userEmail = "test.com"
        viewModel.userEmail = "test@gmail.com.br"

        verifyOrder {
            mockObserver.onChanged(false)
            mockObserver.onChanged(true)
            mockObserver.onChanged(false)
            mockObserver.onChanged(true)
        }

    }
}