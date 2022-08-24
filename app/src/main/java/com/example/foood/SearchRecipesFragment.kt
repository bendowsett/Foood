package com.example.foood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    lateinit var viewModel: SearchRecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchRecipesBinding.inflate(inflater, container, false)
        viewModel = SearchRecipesViewModel()

        binding.searchRecipeButton.setOnClickListener {
            val ingredient = binding.searchField.text.toString()
            viewModel.getRecipesDetails(ingredient)
        }

        return binding.root
    }




}