package com.example.foood

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.foood.database.Favorite
import com.example.foood.databinding.FragmentRecipeDetailBinding
import com.example.foood.databinding.FragmentRecipeResultsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class Recipedetail : Fragment() {

    lateinit var binding : FragmentRecipeDetailBinding
    private val sharedViewModel: RecipesViewModel by activityViewModels{
        RecipeViewModelFactory(
            (activity?.application as FooodApplication).database.favoriteDao())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)


        sharedViewModel.singleRecipe.observe(viewLifecycleOwner) {recipe ->
            binding.textView.text = recipe.title

           for(i in sharedViewModel.favorites) {
               if(i.recipeName == recipe.title){
                   binding.favoriteIcon.setImageResource(R.drawable.ic_added_to_favorite)}
           }



            binding.recipeDetailRecyclerView.adapter = RecipeDetailAdapter(recipe.extendedIngredients)
            binding.recipeImage.load(recipe.image){
                this.placeholder(R.drawable.loading_img)
            }

            binding.favoriteIcon.setOnClickListener {

                if(inFavorites(sharedViewModel.favorites, recipe.title)){
                    GlobalScope.launch{
                        sharedViewModel.removeFave(recipe.title!!)
                        binding.favoriteIcon.setImageResource(R.drawable.ic_add_to_favorite)
                        sharedViewModel.getFavorites()
                    }
                    Toast.makeText(context, "${recipe.title} removed", Toast.LENGTH_SHORT).show()
                }else {
                    binding.favoriteIcon.setImageResource(R.drawable.ic_added_to_favorite)
                    GlobalScope.launch {
                        sharedViewModel.addFave(
                            recipe.title!!,
                            recipe.instructions!!
                        )
                        sharedViewModel.getFavorites()
                    }
                    Toast.makeText(
                        context,
                        "${inFavorites(sharedViewModel.favorites, recipe.title)}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }



        return binding.root

    }

    fun inFavorites(favorites: List<Favorite>, recipe: String?): Boolean {
        for(i in favorites){
            if(i.recipeName == recipe)
            return true
        }
        return false
    }

}