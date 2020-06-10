package com.example.dogid.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface IdDogEndpoints {
    @Headers("Content-Type: application/json")
    @POST("/signup")
    fun signUp(@Body data: SignUpRequestBody): Call<SignUpResponseBody>
}