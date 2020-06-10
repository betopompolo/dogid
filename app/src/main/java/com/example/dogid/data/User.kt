package com.example.dogid.data

data class User (
    val id: String,
    val email: String,
    val token: String
)

data class AuthUser (
    val email: String = ""
)