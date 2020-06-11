package com.example.dogid.data

enum class DogBreed {
    Husky,
    Hound,
    Pug,
    Labrador,
}

data class Dog(
    val imageUrl: String,
    val breed: DogBreed
)