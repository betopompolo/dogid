package com.example.dogid.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogRepository() {
    private val idDogClient = IdDogClient()
    private val dogMapper = DogMapper()

    fun listByBreed(dogBreed: DogBreed, callback: RepositoryCallback<List<Dog>>, userToken: String) {
        if (userToken.isBlank()) {
            callback.onError(AuthenticationError())
            return
        }

        val feedCategoryOption: FeedCategoryOption? = dogMapper.mapFeedCategoryOption(dogBreed)
        idDogClient.requests.feed(userToken, feedCategoryOption).enqueue(object : Callback<FeedResponseBody> {
            override fun onFailure(call: Call<FeedResponseBody>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(
                call: Call<FeedResponseBody>,
                response: Response<FeedResponseBody>
            ) {
                val body: FeedResponseBody? = response.body()
                if (response.isSuccessful && body != null) {
                    val dogs = dogMapper.mapFeedResponse(body)
                    callback.onSuccess(dogs)
                } else {
                    if (response.code() == 401) {
                        callback.onError(AuthenticationError())
                    } else {
                        callback.onError()
                    }
                }
            }
        })
    }
}