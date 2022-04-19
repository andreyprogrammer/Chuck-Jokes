package com.example.andreymerkurev.chuckjokes.domain.repository

import com.example.andreymerkurev.chuckjokes.data.model.RequestResult
import com.example.andreymerkurev.chuckjokes.domain.entity.Joke

interface JokesRepository {
    suspend fun getJokes(count: String): RequestResult<List<Joke>>
}