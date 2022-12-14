package com.example.foood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.foood.databinding.FragmentSearchRecipesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Cuisines.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchRecipes : Fragment() {
    lateinit var binding : FragmentSearchRecipesBinding

    private val sharedViewModel: RecipesViewModel by activityViewModels{
        RecipeViewModelFactory(
            (activity?.application as FooodApplication).database.favoriteDao())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchRecipesBinding.inflate(inflater, container, false)


        binding.searchRecipeButton.setOnClickListener {
            val ingredient = binding.searchField.text.toString()
            sharedViewModel.getRecipesDetails(ingredient)
            findNavController().navigate(R.id.action_cuisines_to_recipeResultsFragment)
        }


        return binding.root
    }




}