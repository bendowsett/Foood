package com.example.foood.network

data class WinePairing(
    val pairedWines: List<String>?,
    val pairingText: String?,
    val productMatches: List<ProductMatche>?
)