package com.dicoding.netflock.core.utils

import com.dicoding.netflock.core.data.source.remote.response.MoviesItems
import com.dicoding.netflock.core.data.source.remote.response.ShowsItems
import com.dicoding.netflock.core.domain.model.Movie
import com.dicoding.netflock.core.domain.model.TvShow

object DataMapper {
    fun mapResponsesMovieToEntities(input: List<MoviesItems>): List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>()

        input.map {
            val movie = com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                movieId = it.id,
                movieTitle = it.title,
                movieDesc = it.overview,
                movieDate = it.releaseDate,
                moviePoster = it.posterPath,
                favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesMovieToDomain(input: List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                movieTitle = it.movieTitle,
                movieDesc = it.movieDesc,
                movieDate = it.movieDate,
                moviePoster = it.moviePoster,
                favorite = it.favorite
            )
        }

    fun mapDomainMovieToEntity(input: Movie) =
        com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
            movieId = input.movieId,
            movieTitle = input.movieTitle,
            movieDesc = input.movieDesc,
            movieDate = input.movieDate,
            moviePoster = input.moviePoster,
            favorite = input.favorite
        )

    fun mapResponseShowToEntities(input:List<ShowsItems>): List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity> {
        val showList = ArrayList<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>()

        input.map {
            val show = com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                tvShowId = it.id,
                tvShowTitle = it.title,
                tvShowDesc = it.overview,
                tvShowPoster = it.posterPath,
                tvShowDate = it.releaseDate,
                favorite = false
            )
            showList.add(show)
        }
        return showList
    }

    fun mapEntitiesShowToDomain(input: List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                tvShowId = it.tvShowId,
                tvShowTitle = it.tvShowTitle,
                tvShowDesc = it.tvShowDesc,
                tvShowDate = it.tvShowDate,
                tvShowPoster = it.tvShowPoster,
                favorite = it.favorite
            )
        }

    fun mapDomainShowToEntity(input: TvShow) =
        com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
            tvShowId = input.tvShowId,
            tvShowTitle = input.tvShowTitle,
            tvShowDesc = input.tvShowDesc,
            tvShowDate = input.tvShowDate,
            tvShowPoster = input.tvShowPoster,
            favorite = input.favorite
        )
}