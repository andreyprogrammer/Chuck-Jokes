package com.example.andreymerkurev.chuckjokes.data.model

import com.example.andreymerkurev.chuckjokes.domain.entity.Joke

data class ServerResponse(
    val type: String,
    val value: List<Joke>
)