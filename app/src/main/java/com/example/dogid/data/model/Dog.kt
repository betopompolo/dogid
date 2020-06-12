package com.example.dogid.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

enum class DogBreed {
    Husky,
    Hound,
    Pug,
    Labrador,
}

@Parcelize
data class Dog(
    val imageUrl: String,
    val breed: DogBreed
) : Parcelable