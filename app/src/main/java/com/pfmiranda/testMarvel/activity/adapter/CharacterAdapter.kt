package com.pfmiranda.testMarvel.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pfmiranda.testMarvel.R
import com.pfmiranda.testMarvel.models.Results
import com.squareup.picasso.Picasso

class CharacterAdapter(private val data: List<Results>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.name)
        val imageImageView = itemView.findViewById<ImageView>(R.id.image)

        fun updateWithUrl(url: String) {
            Picasso.get().load(url).into(imageImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val contactView = inflater.inflate(R.layout.item_character, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = data.get(position)
        holder.nameTextView.text = character.name
        holder.updateWithUrl(character.thumbnail.path+"."+character.thumbnail.extension)
    }

}