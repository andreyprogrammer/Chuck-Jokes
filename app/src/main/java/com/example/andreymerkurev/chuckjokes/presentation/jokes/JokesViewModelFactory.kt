package com.example.andreymerkurev.chuckjokes.presentation.jokes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.andreymerkurev.chuckjokes.domain.repository.JokesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesViewModelFactory @Inject constructor(
    private val jokesRepository: JokesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JokesViewModel::class.java)) {
            return JokesViewModel(jokesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}