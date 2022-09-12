package com.example.foood.network

data class NestedJSONModel(

    val results: List<Recipes>?
)

data class Recipes(
    val id: String,
    val title: String,
    val image: String,
    val imageType: String
)
