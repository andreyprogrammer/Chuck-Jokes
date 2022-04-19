package com.example.andreymerkurev.chuckjokes.data.repository

import com.example.andreymerkurev.chuckjokes.data.datasourse.NetworkDatasource
import com.example.andreymerkurev.chuckjokes.data.model.RequestResult
import com.example.andreymerkurev.chuckjokes.domain.entity.Joke
import com.example.andreymerkurev.chuckjokes.domain.repository.JokesRepository
import javax.inject.Inject

class JokesRepositoryImpl @Inject constructor(
    private val networkDatasource: NetworkDatasource
) : JokesRepository {

    override suspend fun getJokes(count: String): RequestResult<List<Joke>> {
        val response = networkDatasource.jokeApi.getJokes(count)
        return if (response.isSuccessful) {
            RequestResult.Success(
                response.body()!!.value
            )
        } else {
            RequestResult.Error(
                response.code().toString()
            )
        }
    }
}