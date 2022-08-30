package com.example.foood

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foood.network.NestedJSONModel
import com.example.foood.network.Recipe
import com.example.foood.network.Recipes
import com.example.foood.network.RecipesApi
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipesViewModel : ViewModel() {

    private val _singleRecipe = MutableLiveData<Recipe>()
    val singleRecipe: LiveData<Recipe> = _singleRecipe

    private val _recipes = MutableLiveData<NestedJSONModel>()
    val recipes: LiveData<NestedJSONModel> = _recipes


    fun getRecipesDetails(ingredient: String) {
        try {
            viewModelScope.launch {
                val result = RecipesApi.retrofitService.getRecipes(
                    ingredient,
                    "69a3176367c04b2bb8927b740facdca2"
                )
                _recipes.value = result
                Log.d("this", result.results.toString())
            }
        } catch (e: Exception) {
            Log.e("error", "Failure: ${e.message}")
        }
    }

    fun goToRecipeDetail(recipeId: String) {
        try {
            viewModelScope.launch {
                val result = RecipesApi.retrofitService.getRecipeDetails(
                    recipeId,
                    "69a3176367c04b2bb8927b740facdca2"
                )
                _singleRecipe.value = result
                Log.d("this", result.toString())
            }
        } catch (e: Exception) {
            Log.e("error", "Failure: ${e.message}")

        }

    }

}