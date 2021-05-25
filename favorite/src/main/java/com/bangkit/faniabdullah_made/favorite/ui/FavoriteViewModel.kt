package com.bangkit.faniabdullah_made.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val moviesFavorite = movieUseCase.getFavoriteMovie().asLiveData()
    val tvShowsFavorite = movieUseCase.getFavoriteTvShows().asLiveData()
}