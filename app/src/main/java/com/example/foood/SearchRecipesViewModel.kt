package com.example.foood

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foood.network.RecipesApi
import kotlinx.coroutines.launch

class SearchRecipesViewModel : ViewModel() {
    private var _ingredient: String = ""
    val ingredient = _ingredient

    var recipes: String = ""

    fun setIngredient(input : String){
        _ingredient = input
    }

    fun getRecipesDetails(ingredient: String){
        viewModelScope.launch {
           val result = RecipesApi.retrofitService.getRecipes(ingredient, "69a3176367c04b2bb8927b740facdca2")
            recipes = result
            Log.d("this", recipes)
        }
    }

}