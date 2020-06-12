package com.example.dogid.data.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.dogid.R
import com.example.dogid.data.datasource.IdDogClient
import com.example.dogid.data.datasource.SignUpResponseBody
import com.example.dogid.data.mapper.UserMapper
import com.example.dogid.data.model.AuthUser
import com.example.dogid.data.model.User
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {
    private val idDogClient = IdDogClient()
    private val userMapper = UserMapper()
    private val loggedUserKey = "userTokenKey"

    fun login(authUser: AuthUser, callback: RepositoryCallback<User>) {
        val requestBody = userMapper.mapSignUpRequest(authUser)
        val idDogRequests = idDogClient.requests

        idDogRequests.signUp(requestBody).enqueue(object : Callback<SignUpResponseBody> {
            override fun onResponse(
                call: Call<SignUpResponseBody>,
                response: Response<SignUpResponseBody>
            ) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    callback.onSuccess(userMapper.mapUser(body))
                } else {
                    callback.onError()
                }
            }

            override fun onFailure(call: Call<SignUpResponseBody>, t: Throwable) {
                callback.onError()
            }
        })
    }

    fun saveLoggedUser(loggedUser: User, context: Context?) {
        context?.let {
            val prefs = it.getSharedPreferences(it.getString(R.string.appName), MODE_PRIVATE)
            Gson().toJson(loggedUser).let { userJson ->
                prefs.edit().putString(loggedUserKey, userJson).apply()
            }
        }
    }

    fun getLoggedUser(context: Context?): User? {
        return context?.let {
            val prefs = it.getSharedPreferences(it.getString(R.string.appName), MODE_PRIVATE)
            val userJson: String? = prefs.getString(loggedUserKey, null)
            userJson?.let {json ->
                return Gson().fromJson(json, User::class.java)
            }

        }
    }

}