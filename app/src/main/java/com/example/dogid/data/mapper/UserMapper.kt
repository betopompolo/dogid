package com.example.dogid.data.mapper

import com.example.dogid.data.datasource.SignUpRequestBody
import com.example.dogid.data.datasource.SignUpResponseBody
import com.example.dogid.data.model.AuthUser
import com.example.dogid.data.model.User

class UserMapper {
    fun mapSignUpRequest(authUser: AuthUser) =
        SignUpRequestBody(authUser.email)

    fun mapUser(signUpResponseBody: SignUpResponseBody): User {
        val signUpUser = signUpResponseBody.user

        return User(
            signUpUser._id,
            signUpUser.email,
            signUpUser.token
        )
    }
}