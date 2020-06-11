package com.example.dogid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dogid.R
import com.example.dogid.data.Dog
import com.example.dogid.data.DogBreed.Husky
import kotlinx.android.synthetic.main.activity_dog_gallery.*

class DogGalleryActivity : AppCompatActivity() {
    // TODO: Share vm with all fragments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_gallery)
    }
}
