package com.example.foood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foood.network.Recipes

class RecipeResultAdapter(private val dataset: List<Recipes>?) : RecyclerView.Adapter<RecipeResultAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.item_title)
        //var imageView: ImageView = view.findViewById(R.id.recipeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val recipe = dataset!![position]
        holder.textView.text = recipe.title
        //holder.imageView.set
    }

    override fun getItemCount(): Int {
        return dataset!!.size
    }
}