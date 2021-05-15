package com.bangkit.faniabdullah_made.core.data.source.local

import com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity
import com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {
    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getListMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getBookmarkedMovie()

    suspend fun insertMovie(movie: List<MovieEntity>) = movieDao.insertMovie(movie)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateMovie(movie)
    }

    fun searchMovie(value: String): Flow<List<MovieEntity>> = movieDao.searchMovies(value)
}