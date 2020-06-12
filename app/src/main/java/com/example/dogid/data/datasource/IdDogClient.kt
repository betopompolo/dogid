package com.example.dogid.data.datasource

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val jsonConverter: Gson = GsonBuilder()
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    .create()

class IdDogClient {
    private val baseUrl = "https://iddog-nrizncxqba-uc.a.run.app"
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit
        .Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(jsonConverter))
        .baseUrl(baseUrl)
        .build()

    val requests: IdDogEndpoints = retrofit.create(
        IdDogEndpoints::class.java)
}
