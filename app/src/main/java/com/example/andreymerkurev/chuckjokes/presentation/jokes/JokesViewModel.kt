package com.example.andreymerkurev.chuckjokes.presentation.jokes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.andreymerkurev.chuckjokes.data.model.RequestResult
import com.example.andreymerkurev.chuckjokes.domain.entity.Joke
import com.example.andreymerkurev.chuckjokes.domain.repository.JokesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokesViewModel @Inject constructor(
    private val jokesRepository: JokesRepository
) : ViewModel() {

    private val _listJokes = MutableLiveData<List<Joke>>().apply {
        value = listOf()
    }
    val listJokes: LiveData<List<Joke>> = _listJokes

    private val _status = MutableLiveData<Status>().apply {
        value = Status.SUCCESS
    }
    val status: LiveData<Status> = _status

    enum class Status {
        SUCCESS,
        ERROR
    }

    fun getJokes(count: String) {
        _status.value = Status.SUCCESS
        viewModelScope.launch {
            if (count.isNotEmpty()) {
                try {
                    val response = jokesRepository.getJokes(count)
                    when (response) {
                        is RequestResult.Success -> {
                            _listJokes.value = response.data
                            _status.value = Status.SUCCESS
                        }
                        is RequestResult.Error -> {
                            _status.value = Status.ERROR
                        }
                    }
                } catch (e: Exception) {
                    _status.value = Status.ERROR
                }
            }
        }
    }
}