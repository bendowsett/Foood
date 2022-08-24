package com.example.foood.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.spoonacular.com/recipes/"

private val retrofit = Retrofit.Builder()
     .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RecipeApiService {
    @GET("complexSearch")
    suspend fun getRecipes(@Query("query")query: String, @Query("apiKey")apiKey: String): String
}

object RecipesApi {
    val retrofitService : RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }
}
