package com.example.foood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.foood.databinding.FragmentRecipeResultsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeResultsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeResultsFragment : Fragment() {
    private val sharedViewModel: RecipesViewModel by activityViewModels{
       RecipeViewModelFactory(
           (activity?.application as FooodApplication).database.favoriteDao())

    }
    lateinit var binding: FragmentRecipeResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipeResultsBinding.inflate(inflater, container, false)

        sharedViewModel.recipes.observe(viewLifecycleOwner) { newRecipes ->
            binding.recyclerView.adapter = RecipeResultAdapter(newRecipes.results, ::onClick)

        }

        return binding.root
    }

    fun onClick(id: String){
        sharedViewModel.goToRecipeDetail(id)
        findNavController().navigate(R.id.action_recipeResultsFragment_to_recipe_detail)
    }

}