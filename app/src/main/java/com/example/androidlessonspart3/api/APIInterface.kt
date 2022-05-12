package com.example.androidlessonspart3.api

import com.example.androidlessonspart3.models.api.NewsByCategoryResponse
import com.example.androidlessonspart3.models.api.disney.DisneyCharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    // fetch news by selected category
    @GET("news")
    suspend fun getNewsByCategory(@Query("category") category: String): Response<NewsByCategoryResponse>

    @GET("/characters")
    suspend fun getDisneyCharacters(): Response<DisneyCharacterModel>
}