package com.example.dogid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dogid.R
import kotlinx.android.synthetic.main.fragment_dog_breeds.*

class DogBreedsFragment : Fragment() {
    private val viewModel: DogGalleryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_breeds, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dogBreedsView.adapter = DogBreedsAdapter { selectedDogBreed ->
            viewModel.setSelectedDogBreed(selectedDogBreed)
        }
    }
}