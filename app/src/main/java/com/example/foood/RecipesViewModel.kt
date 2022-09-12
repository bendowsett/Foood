package com.example.foood

import android.util.Log
import androidx.lifecycle.*
import com.example.foood.database.Favorite
import com.example.foood.database.FavoriteDao

import com.example.foood.network.NestedJSONModel
import com.example.foood.network.models.Recipe
import com.example.foood.network.RecipesApi
import com.example.foood.network.models.AnalyzedInstruction
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipesViewModel(private val favoriteDao: FavoriteDao) : ViewModel() {

    var favorites = listOf<Favorite>()

    fun getFaves(): List<Favorite>{
        return favoriteDao.getAll()

    }

    fun addFave(name: String, instruction: String){
        favoriteDao.addItems(name, instruction)
    }

    fun removeFave(name:String){
        favoriteDao.removeItem(name)
    }

    init{
       getFavorites()
    }


    
    private val _singleRecipe = MutableLiveData<Recipe>()
    val singleRecipe: LiveData<Recipe> = _singleRecipe

    private val _recipes = MutableLiveData<NestedJSONModel>()
    val recipes: LiveData<NestedJSONModel> = _recipes


    fun getFavorites(){
        GlobalScope.launch{favorites = getFaves()}

    }



    fun getRecipesDetails(ingredient: String) {
        try {
            viewModelScope.launch {
                val result = RecipesApi.retrofitService.getRecipes(
                    ingredient,
                    "69a3176367c04b2bb8927b740facdca2"
                )
                _recipes.value = result

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
            }
        } catch (e: Exception) {
            Log.e("error", "Failure: ${e.message}")

        }

    }

}

class RecipeViewModelFactory(private val favoriteDao: FavoriteDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipesViewModel(favoriteDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}