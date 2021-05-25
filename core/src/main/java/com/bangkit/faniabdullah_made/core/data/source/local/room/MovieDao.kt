package com.bangkit.faniabdullah_made.core.data.source.local.room

import androidx.room.*
import com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Update
    fun updateMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<MovieEntity>)

    @Query("SELECT * FROM tb_movie where isTvShows = 0 ")
    fun getListMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_movie where bookmarked = 1 and isTvShows = 0")
    fun getBookmarkedMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_movie WHERE  title LIKE '%' || :search || '%' and isTvShows = 0")
    fun searchMovies(search: String): Flow<List<MovieEntity>>


    @Query("SELECT * FROM tb_movie where isTvShows = 1 ")
    fun getListTvShows(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_movie where bookmarked = 1 and isTvShows = 1")
    fun getBookmarkedTvShows(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_movie WHERE  title LIKE '%' || :search || '%' and isTvShows = 1")
    fun searchTvShows(search: String): Flow<List<MovieEntity>>
}