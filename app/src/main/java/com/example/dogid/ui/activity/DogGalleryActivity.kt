package com.example.dogid.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dogid.R
import com.example.dogid.data.model.Dog
import com.example.dogid.ui.viewmodel.DogGalleryViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_dog_gallery.*

class DogGalleryActivity : AppCompatActivity() {
    private val viewModel: DogGalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_gallery)
        val contentView: View = findViewById(android.R.id.content)

        lifecycle.addObserver(viewModel)

        viewModel.selectedDogBreed.observe(this, Observer {selectedDogBreed ->
            title = selectedDogBreed.name.capitalize()
        })

        viewModel.dogs.observe(this, Observer { dogs ->
            setLoading(dogs.isEmpty())
        })

        viewModel.fetchDogsError.observe(this, Observer { error ->
            val errorMessage = error?.message ?: getText(R.string.defaultErrorMessage)
            Snackbar.make(contentView, errorMessage, Snackbar.LENGTH_SHORT).show()
        })

        viewModel.onImageClickListener = { selectedDog ->
            openDogDetailActivity(selectedDog)
        }
    }

    private fun setLoading(showLoading: Boolean) {
        if (showLoading) {
            loadingIndicator.visibility = VISIBLE
            dogGalleryFragment.visibility = GONE
        } else {
            loadingIndicator.visibility = GONE
            dogGalleryFragment.visibility = VISIBLE
        }
    }

    private fun openDogDetailActivity(dog: Dog) {
        val intent = Intent(this, DogDetailActivity::class.java)
        intent.putExtra(dogKey, dog)
        startActivity(intent)
    }
}
