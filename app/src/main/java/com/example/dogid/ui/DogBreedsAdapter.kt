package com.example.dogid.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogid.R
import com.example.dogid.data.DogBreed
import kotlinx.android.synthetic.main.dog_breeds_item.view.*

class DogBreedsAdapter(private val dogBreeds: List<DogBreed>) : RecyclerView.Adapter<DogBreedsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textItem = itemView.dogBreedTextItem

        fun bind(dogBreed: DogBreed, isSelected: Boolean) {
            textItem.text = dogBreed.name.capitalize()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dog_breeds_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = dogBreeds.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dogBreed = dogBreeds[position]

        holder.bind(dogBreed, false)
    }
}