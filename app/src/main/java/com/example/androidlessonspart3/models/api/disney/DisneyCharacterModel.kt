package com.example.androidlessonspart3.models.api.disney

data class DisneyCharacterModel(
    val count: Int,
    val `data`: List<Data>,
    val nextPage: String,
    val totalPages: Int
)