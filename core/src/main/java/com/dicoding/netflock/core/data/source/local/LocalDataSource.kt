package com.dicoding.netflock.core.data.source.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val netflockDao: com.dicoding.netflock.core.data.source.local.room.NetflockDao) {

    fun getAllMovies(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>> = netflockDao.getAllMovies()

    fun getAllShows(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>> = netflockDao.getAllShows()

    /*fun getMovie(movieId: Int): LiveData<MovieEntity> = netflockDao.getMovie(movieId)

    fun getShow(showId: Int): LiveData<TvShowEntity> = netflockDao.getShow(showId)*/

    fun getFavMovie(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>> = netflockDao.getFavMovies()

    fun getFavShows(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>> = netflockDao.getFavShows()

    suspend fun insertMovie(movie: List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>) = netflockDao.insertMovie(movie)

    suspend fun insertShow(show: List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>) = netflockDao.insertShow(show)

    fun setFavMovie(movieEntity: com.dicoding.netflock.core.data.source.local.entity.MovieEntity, state: Boolean) {
        movieEntity.favorite = state
        netflockDao.updateMovies(movieEntity)
    }

    fun setFavShow(tvShowEntity: com.dicoding.netflock.core.data.source.local.entity.TvShowEntity, state: Boolean) {
        tvShowEntity.favorite = state
        netflockDao.updateShows(tvShowEntity)
    }
}