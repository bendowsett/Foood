package com.example.foood.network.models

import com.example.foood.network.models.Equipment
import com.example.foood.network.models.Ingredient
import com.example.foood.network.models.Length

data class Step(
    val equipment: List<Equipment>?,
    val ingredients: List<Ingredient>?,
    val length: Length?,
    val number: Int?,
    val step: String?
)