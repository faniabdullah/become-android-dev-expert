package com.bangkit.faniabdullah_made.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(movieUseCase: MovieUseCase) : ViewModel() {
    val movies = movieUseCase.getAllMovie().asLiveData()
}