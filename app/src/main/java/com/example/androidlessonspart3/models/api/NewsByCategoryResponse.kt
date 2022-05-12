package com.example.androidlessonspart3.models.api

data class NewsByCategoryResponse(
    val category: String,
    val `data`: List<Data>,
    val success: Boolean
)