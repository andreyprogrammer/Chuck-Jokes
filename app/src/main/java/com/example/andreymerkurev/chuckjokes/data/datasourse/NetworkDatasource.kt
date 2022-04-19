package com.example.andreymerkurev.chuckjokes.data.datasourse

import com.example.andreymerkurev.chuckjokes.data.network.ApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDatasource {
    private val baseUrl = "https://api.icndb.com"

    private val gson = GsonBuilder()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val jokeApi: ApiService by lazy { retrofit.create(ApiService::class.java) }
}