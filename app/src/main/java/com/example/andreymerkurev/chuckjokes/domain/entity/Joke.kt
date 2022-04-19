package com.example.andreymerkurev.chuckjokes.domain.entity

data class Joke(
    val id: Int,
    val joke: String
) {
    fun idToString() = id.toString()

    fun formattedJoke() = joke.replace("&quot;", "\"")
}