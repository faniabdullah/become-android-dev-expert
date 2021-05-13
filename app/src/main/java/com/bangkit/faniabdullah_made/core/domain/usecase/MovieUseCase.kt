package com.bangkit.faniabdullah_made.core.domain.usecase

import com.bangkit.faniabdullah_made.core.data.Resource
import com.bangkit.faniabdullah_made.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}