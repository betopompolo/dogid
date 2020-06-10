package com.example.dogid.data

import java.util.*

data class SignUpRequestBody(val email: String)

data class SignUpUserResponse (
    val email: String,
    val _id: String,
    val token: String,
    val createdAt: Date,
    val updatedAt: Date
)
data class SignUpResponseBody (
    val user: SignUpUserResponse
)