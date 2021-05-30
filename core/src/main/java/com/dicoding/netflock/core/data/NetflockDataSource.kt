package com.dicoding.netflock.core.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.netflock.core.data.source.local.entity.MovieEntity
import com.dicoding.netflock.core.data.source.local.entity.TvShowEntity

interface NetflockDataSource {

    fun getAllMovies() : LiveData<Resource<List<MovieEntity>>>

    fun getAllTvShows() : LiveData<Resource<PagedList<TvShowEntity>>>

    /*fun getMovie(movieId: Int) : LiveData<Resource<MovieEntity>>

    fun getTvShow(tvShowId: Int) : LiveData<Resource<TvShowEntity>>*/

    fun getFavMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavShows(): LiveData<PagedList<TvShowEntity>>

    fun setFavMovies(movieEntity: MovieEntity, state: Boolean)

    fun setFavShows(tvShowEntity: TvShowEntity, state: Boolean)

}