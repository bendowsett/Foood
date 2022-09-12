package com.example.foood.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "recipe_name") val recipeName:String,
    @NonNull @ColumnInfo(name = "recipe_instructions") val recipeInstruction: String,



)
