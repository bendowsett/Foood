package com.example.foood.network.models

import com.example.foood.network.models.ProductMatche

data class WinePairing(
    val pairedWines: List<String>?,
    val pairingText: String?,
    val productMatches: List<ProductMatche>?
)