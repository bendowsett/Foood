package com.example.foood.database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query



@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite")
       fun getAll(): List<Favorite>

    @Query("INSERT INTO favorite VALUES(null, :recipeName, :recipeInstructions)")
      fun addItems(recipeName: String, recipeInstructions: String? )

    @Query("DELETE FROM favorite WHERE recipe_name = :name")
        fun removeItem(name: String)
}