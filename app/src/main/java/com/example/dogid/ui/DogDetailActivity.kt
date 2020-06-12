package com.example.dogid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dogid.R
import com.example.dogid.data.Dog
import kotlinx.android.synthetic.main.activity_dog_detail.*

const val dogKey = "dogKey"

class DogDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)

        title = ""

        bindDog()
    }

    private fun bindDog() {
        intent.getParcelableExtra<Dog>(dogKey)?.let { dog ->
            Glide.with(this)
                .load(dog.imageUrl)
                .placeholder(R.drawable.ic_app)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(dogImage)
        }
    }
}