package com.example.dogid.data

interface RepositoryCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Error? = null)
}