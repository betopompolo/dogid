package com.example.dogid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dogid.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        userEmailEditText.doAfterTextChanged { userEmail ->
            viewModel.userEmail = userEmail?.toString() ?: ""
        }
        viewModel.isLoginFormValid.observe(this, Observer { isValid ->
            loginButton.isEnabled = isValid
        })
    }
}