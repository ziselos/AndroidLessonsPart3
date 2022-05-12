package com.example.androidlessonspart3.api

import com.example.androidlessonspart3.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object DisneyAPIClient {
    private var retrofit: Retrofit? = null
    val disneyClient: Retrofit?
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel((HttpLoggingInterceptor.Level.BODY))
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.DISNEY_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }
}