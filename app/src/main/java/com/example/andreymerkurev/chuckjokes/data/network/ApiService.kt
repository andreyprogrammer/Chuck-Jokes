package com.example.andreymerkurev.chuckjokes.data.network

import com.example.andreymerkurev.chuckjokes.data.model.ServerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/jokes/random/{count}")
    suspend fun getJokes(
        @Path("count") count: String
    ): Response<ServerResponse>
}