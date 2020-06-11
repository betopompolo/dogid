package com.example.dogid.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogid.R
import com.example.dogid.data.Dog
import kotlinx.android.synthetic.main.dog_gallery_item.view.*

class DogGalleryAdapter(private val dogs: List<Dog>, private val context: Context) : RecyclerView.Adapter<DogGalleryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.dogGalleryItemImage

        fun bind(dog: Dog, position: Int) {
            if (position % 2 == 0) {
                image.setBackgroundColor(context.resources.getColor(R .color.colorAccent))
            } else {
                image.setBackgroundColor(context.resources.getColor(R.color.black))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dog_gallery_item, parent, false)

        return ViewHolder(itemView, context)
    }

    override fun getItemCount() = dogs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog = dogs[position]

        holder.bind(dog, position)
    }
}