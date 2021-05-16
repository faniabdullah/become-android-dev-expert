package com.bangkit.faniabdullah_made.core.utils

import com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity
import com.bangkit.faniabdullah_made.core.data.source.remote.response.movie.MovieResponse
import com.bangkit.faniabdullah_made.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity>()
        input.map { movieResponse ->

            val movie = com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity(
                movie_id = movieResponse.id,
                name = movieResponse.originalTitle,
                overview = movieResponse.overview,
                poster_path = movieResponse.posterPath,
                release_date = movieResponse.releaseDate,
                vote_average = movieResponse.voteAverage,
                vote_count = movieResponse.voteCount,
                isFavorite = false,
                original_langugage = movieResponse.originalLanguage
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.movie_id,
                name = it.name.toString(),
                overview = it.overview,
                poster = it.poster_path,
                isFavorite = it.isFavorite,
                vote_average = it.vote_average,
                release_date = it.release_date,
                vote_count = it.vote_count,
                original_language = it.original_langugage
            )
        }

    fun mapDomainToEntity(input: Movie) =
        com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity(
            movie_id = input.id,
            overview = input.overview,
            name = input.name,
            poster_path = input.poster,
            vote_average = input.vote_average,
            isFavorite = input.isFavorite,
            release_date = input.release_date,
            vote_count = input.vote_count,
            original_langugage = input.original_language
        )
}