package com.example.dogid.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dogid.R
import com.example.dogid.data.DogBreed
import kotlinx.android.synthetic.main.fragment_dog_breeds.*

class DogBreedsFragment : Fragment() {
    // TODO: Get it from vm
    val mockedDogBreeds: List<DogBreed> = listOf(
        DogBreed.Husky,
        DogBreed.Hound,
        DogBreed.Labrador,
        DogBreed.Pug
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_breeds, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dogBreedsView.apply {
            adapter = DogBreedsAdapter(mockedDogBreeds)
        }
    }
}