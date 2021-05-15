package com.bangkit.faniabdullah_made.core.utils

import com.bangkit.faniabdullah_made.core.data.source.local.entity.MovieEntity
import com.bangkit.faniabdullah_made.core.data.source.remote.response.movie.MovieResponse
import com.bangkit.faniabdullah_made.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map { movieResponse ->
            val movie = MovieEntity(
                movie_id = movieResponse.id,
                name = movieResponse.originalTitle,
                overview = movieResponse.overview,
                poster_path = movieResponse.posterPath,
                release_date = movieResponse.releaseDate,
                vote_average = movieResponse.voteAverage,
                vote_count = movieResponse.voteCount,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.movie_id,
                name = it.name.toString(),
                overview = it.overview,
                poster = it.poster_path,
                isFavorite = false,
                vote_average = it.vote_average
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movie_id = input.id,
        overview = input.overview,
        name = input.name,
        poster_path = input.poster,
        vote_average = input.vote_average,
        isFavorite = input.isFavorite
    )
}