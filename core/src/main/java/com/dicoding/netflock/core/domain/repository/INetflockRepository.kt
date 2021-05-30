package com.dicoding.netflock.core.domain.repository

import com.dicoding.netflock.core.domain.model.Movie
import com.dicoding.netflock.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface INetflockRepository {
    fun getAllMovies() : Flow<com.dicoding.netflock.core.data.Resource<List<Movie>>>

    fun getAllTvShows() : Flow<com.dicoding.netflock.core.data.Resource<List<TvShow>>>

    fun getFavMovies(): Flow<List<Movie>>

    fun getFavShows(): Flow<List<TvShow>>

    fun setFavMovies(movieEntity: Movie, state: Boolean)

    fun setFavShows(tvShowEntity: TvShow, state: Boolean)
}