package com.example.dogid.data.datasource

import retrofit2.Call
import retrofit2.http.*


interface IdDogEndpoints {
    @Headers("Content-Type: application/json")
    @POST("/signup")
    fun signUp(@Body data: SignUpRequestBody): Call<SignUpResponseBody>

    @GET("/feed")
    fun feed(@Header("Authorization") token: String, @Query("category") category: FeedCategoryOption?): Call<FeedResponseBody>
}