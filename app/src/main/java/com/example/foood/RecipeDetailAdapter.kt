package com.example.foood

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foood.databinding.IngredientDetailsBinding
import com.example.foood.network.models.ExtendedIngredient

class RecipeDetailAdapter (private val ingredient: List<ExtendedIngredient>?) : RecyclerView.Adapter<RecipeDetailAdapter.ViewHolder>(){

    class ViewHolder(binding: IngredientDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        val ingredient: TextView = binding.ingredient

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(IngredientDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = ingredient?.get(position)
        if (recipe != null) {
            holder.ingredient.text = "${recipe.amount.toString()} ${recipe.unit} ${recipe.name}"
        }

    }

    override fun getItemCount(): Int {
        return ingredient!!.size
    }

}