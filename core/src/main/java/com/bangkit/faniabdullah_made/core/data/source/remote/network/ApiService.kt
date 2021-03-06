package com.bangkit.faniabdullah_made.core.data.source.remote.network

import com.bangkit.faniabdullah_made.core.data.source.remote.response.ListMovieResponse
import com.bangkit.faniabdullah_made.core.data.source.remote.response.movie.MovieResponse
import com.bangkit.faniabdullah_made.core.data.source.remote.response.tvshows.TvShowsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import com.bangkit.faniabdullah_made.core.BuildConfig.MOVIE_TOKEN as ApiKey

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getMovieNowPlaying(
        @Query("api_key") apiKey: String = ApiKey
    ): ListMovieResponse<MovieResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey: String = ApiKey
    ): ListMovieResponse<TvShowsResponse>

}