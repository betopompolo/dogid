package com.example.dogid.data.repository

interface RepositoryCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Error? = null)
}