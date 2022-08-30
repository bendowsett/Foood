package com.example.foood.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL =
    "https://api.spoonacular.com/recipes/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
     .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RecipeApiService {
    @GET("complexSearch")
    suspend fun getRecipes(@Query("query")query: String, @Query("apiKey")apiKey: String): NestedJSONModel

    @GET("{id}/information")
    suspend fun getRecipeDetails(@Path("id")id: String, @Query("apiKey")apiKey: String): Recipe
}

object RecipesApi {
    val retrofitService : RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }
}
