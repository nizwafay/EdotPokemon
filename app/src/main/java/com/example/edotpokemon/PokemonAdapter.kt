package com.example.edotpokemon

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.edotpokemon.domain.model.Pokemon

class PokemonAdapter(): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    var data: List<Pokemon> = listOf()

    fun submitData(newData: List<Pokemon>?) {
        data = newData ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pokemon: Pokemon = data[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.load("https://img.pokemondb.net/artwork/large/${pokemon.name}.jpg")

        // sets the text to the textview from our itemHolder class
        holder.textView.text = pokemon.name

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return data.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}