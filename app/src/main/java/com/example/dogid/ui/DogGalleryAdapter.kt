package com.example.dogid.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC
import com.example.dogid.R
import com.example.dogid.data.Dog
import kotlinx.android.synthetic.main.dog_gallery_item.view.*

class DogGalleryAdapter(var dogs: List<Dog>) : RecyclerView.Adapter<DogGalleryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.dogGalleryItemImage

        fun bind(dog: Dog) {
            Glide.with(itemView)
                .load(dog.imageUrl)
                .placeholder(R.drawable.ic_dog_placeholder)
                .diskCacheStrategy(AUTOMATIC)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dog_gallery_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = dogs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog = dogs[position]

        holder.bind(dog)
    }

    fun setData(newDogs: List<Dog>) {
        dogs = newDogs
        notifyDataSetChanged()
    }
}