package com.example.dogid.data

class UserMapper {
    fun mapSignUpRequest(authUser: AuthUser) = SignUpRequestBody(authUser.email)

    fun mapUser(signUpResponseBody: SignUpResponseBody): User {
        val signUpUser = signUpResponseBody.user

        return User(
            signUpUser._id,
            signUpUser.email,
            signUpUser.token
        )
    }
}