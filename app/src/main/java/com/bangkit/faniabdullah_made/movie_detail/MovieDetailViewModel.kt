package com.bangkit.faniabdullah_made.movie_detail

import androidx.lifecycle.ViewModel
import com.bangkit.faniabdullah_made.core.domain.model.Movie
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val movieUseCase: MovieUseCase) :
    ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}