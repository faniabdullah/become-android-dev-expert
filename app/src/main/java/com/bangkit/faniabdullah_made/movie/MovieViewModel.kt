package com.bangkit.faniabdullah_made.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*


@FlowPreview
@ExperimentalCoroutinesApi
class MovieViewModel @ViewModelInject constructor(movieUseCase: MovieUseCase) : ViewModel() {
    val movies = movieUseCase.getAllMovie().asLiveData()

    private val queryChannel = ConflatedBroadcastChannel<String>()

    fun setSearchQuery(search: String) {
        queryChannel.offer(search)
    }

    val movieResult = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .flatMapLatest {
            movieUseCase.searchMovie(it)
        }.asLiveData()
}