package com.bangkit.faniabdullah_made.movie_detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.bangkit.faniabdullah_made.core.domain.model.Movie
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase


class MovieDetailViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase) :
    ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}