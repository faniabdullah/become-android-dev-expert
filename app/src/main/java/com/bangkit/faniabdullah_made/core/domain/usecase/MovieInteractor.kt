package com.bangkit.faniabdullah_made.core.domain.usecase

import com.bangkit.faniabdullah_made.core.data.Resource
import com.bangkit.faniabdullah_made.core.domain.model.Movie
import com.bangkit.faniabdullah_made.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository) :
    MovieUseCase {
    override fun getAllMovie(): Flow<Resource<List<Movie>>> = movieRepository.getAllMovie()
    override fun getFavoriteMovie(): Flow<List<Movie>> = movieRepository.getFavoriteMovie()
    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)

    override fun searchMovie(value: String): Flow<List<Movie>> = movieRepository.searchMovie(value)

}