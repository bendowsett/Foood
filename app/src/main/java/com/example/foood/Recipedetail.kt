package com.example.foood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.foood.databinding.FragmentRecipeDetailBinding
import com.example.foood.databinding.FragmentRecipeResultsBinding

class Recipedetail : Fragment() {

    lateinit var binding : FragmentRecipeDetailBinding
    private val sharedViewModel: RecipesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        sharedViewModel.singleRecipe.observe(viewLifecycleOwner) {recipe ->
            binding.textView.text = recipe.title
            binding.recipeImage.load(recipe.image)
        }

        return binding.root

    }


}