package com.example.dogid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.HORIZONTAL
import android.widget.GridLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dogid.R
import com.example.dogid.data.Dog
import com.example.dogid.data.DogBreed
import kotlinx.android.synthetic.main.dog_gallery_fragment.*
import kotlinx.android.synthetic.main.dog_gallery_item.view.*

class DogGalleryFragment : Fragment() {

    //TODO: Use the same viewModel as Activity is using

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dog_gallery_fragment, container, false)
    }

    private val mockedDogs: List<Dog> = listOf(
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10047.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10116.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10171.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10175.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10273.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10360.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10597.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_1066.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10844.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10849.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10875.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10898.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10902.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10955.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_10967.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11114.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11131.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11138.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11287.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_1130.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11396.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11409.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11445.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11580.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11626.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11635.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11636.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_1164.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11773.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_1178.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11783.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_11841.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_120.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12120.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12380.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12441.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12478.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12498.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12656.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12678.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_12748.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_1289.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13127.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13158.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13187.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13197.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13282.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_1338.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13423.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13434.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13704.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13794.jpg", DogBreed.Husky),
        Dog("https://images.dog.ceo/breeds/husky/n02110185_13821.jpg", DogBreed.Husky)
    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dogGalleryView.apply {
            adapter = DogGalleryAdapter(mockedDogs, context)
        }
    }
}