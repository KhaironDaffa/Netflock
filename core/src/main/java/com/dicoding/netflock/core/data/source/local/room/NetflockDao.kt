package com.dicoding.netflock.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NetflockDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM shows")
    fun getAllShows(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>>

    /*@Query("SELECT * FROM movies WHERE movieId LIKE :movieId")
    fun getMovie(movieId: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM shows WHERE showId LIKE :showId")
    fun getShow(showId: Int): LiveData<TvShowEntity>*/

    @Query("SELECT * FROM movies WHERE favorite = 1")
    fun getFavMovies(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM shows WHERE favorite = 1")
    fun getFavShows(): Flow<List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movieEntity: List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShow(showEntity: List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>)

    @Update
    fun updateMovies(movieEntity: com.dicoding.netflock.core.data.source.local.entity.MovieEntity)

    @Update
    fun updateShows(tvShowEntity: com.dicoding.netflock.core.data.source.local.entity.TvShowEntity)
}