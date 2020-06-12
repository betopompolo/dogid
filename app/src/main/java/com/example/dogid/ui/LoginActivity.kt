package com.example.dogid.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import com.example.dogid.R
import com.example.dogid.data.AuthUser
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val contentView: View = findViewById(android.R.id.content)

        loginButton.setOnClickListener {
            setLoading(true)
            viewModel.login()
        }

        userEmailEditText.doAfterTextChanged { userEmail ->
            viewModel.authUser = AuthUser(userEmail?.toString() ?: "")
        }

        viewModel.isLoginFormValid.observe(this, Observer { isValid ->
            loginButton.isEnabled = isValid
        })

        viewModel.loggedUser.observe(this, Observer {
            setLoading(false)
            openDogGallery()
        })

        viewModel.loginError.observe(this, Observer {
            setLoading(false)
            Snackbar.make(contentView, it.message ?: getString(R.string.defaultErrorMessage), Snackbar.LENGTH_SHORT).show()
        })

        lifecycle.addObserver(viewModel)
    }

    private fun setLoading(showLoading: Boolean) {
        loginButton.text = if (showLoading)
            getString(R.string.loginButtonProgress) else
            getString(R.string.loginButton)
        loginButton.isEnabled = !showLoading
    }

    private fun openDogGallery() {
        val intent = Intent(this, DogGalleryActivity::class.java)
        startActivity(intent)
    }
}