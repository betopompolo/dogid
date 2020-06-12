package com.example.dogid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.dogid.R
import kotlinx.android.synthetic.main.dog_gallery_fragment.*

class DogGalleryFragment : Fragment() {

    private val viewModel: DogGalleryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dog_gallery_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dogGalleryView.adapter = DogGalleryAdapter(viewModel.dogs.value ?: emptyList())

        viewModel.dogs.observe(viewLifecycleOwner, Observer { dogs ->
            val adapter: DogGalleryAdapter = dogGalleryView.adapter as DogGalleryAdapter
            adapter.setData(dogs)
        })
    }
}
