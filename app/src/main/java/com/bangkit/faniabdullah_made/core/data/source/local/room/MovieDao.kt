package com.bangkit.faniabdullah_made.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Update
    fun updateMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<MovieEntity>)

    @Query("SELECT * FROM tb_movie ")
    fun getListMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_movie where bookmarked = 1")
    fun getBookmarkedMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_movie WHERE movieId = :movieId")
    fun getDetailMovieById(movieId: Int): LiveData<MovieEntity>
}