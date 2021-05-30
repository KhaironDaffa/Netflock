package com.dicoding.netflock.core.data

import com.dicoding.netflock.core.data.source.remote.api.ApiResponse
import com.dicoding.netflock.core.data.source.remote.response.MoviesItems
import com.dicoding.netflock.core.data.source.remote.response.ShowsItems
import com.dicoding.netflock.core.domain.model.Movie
import com.dicoding.netflock.core.domain.model.TvShow
import com.dicoding.netflock.core.domain.repository.INetflockRepository
import com.dicoding.netflock.core.utils.AppExecutors
import com.dicoding.netflock.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetflockRepository @Inject constructor(
    private val remoteDataSource: com.dicoding.netflock.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.dicoding.netflock.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors) : INetflockRepository {

    override fun getAllMovies(): Flow<com.dicoding.netflock.core.data.Resource<List<Movie>>> {
        return object : com.dicoding.netflock.core.data.NetworkBoundResource<List<Movie>, List<MoviesItems>>(appExecutors) {
            public override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies().map { DataMapper.mapEntitiesMovieToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MoviesItems>>> = remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MoviesItems>) {
                val movieList = DataMapper.mapResponsesMovieToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    }

    override fun getAllTvShows(): Flow<com.dicoding.netflock.core.data.Resource<List<TvShow>>> {
        return object : com.dicoding.netflock.core.data.NetworkBoundResource<List<TvShow>, List<ShowsItems>>(appExecutors) {
            override fun loadFromDB(): Flow<List<TvShow>> {
                return localDataSource.getAllShows().map { DataMapper.mapEntitiesShowToDomain(it) }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ShowsItems>>> = remoteDataSource.getAllTvShows()

            override suspend fun saveCallResult(data: List<ShowsItems>) {
                val tvShowList = DataMapper.mapResponseShowToEntities(data)
                localDataSource.insertShow(tvShowList)
            }
        }.asFlow()

    }

    override fun getFavMovies(): Flow<List<Movie>> {
        return localDataSource.getFavMovie().map { DataMapper.mapEntitiesMovieToDomain(it) }
    }


    override fun getFavShows(): Flow<List<TvShow>> {
        return localDataSource.getFavShows().map { DataMapper.mapEntitiesShowToDomain(it) }
    }

    override fun setFavMovies(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainMovieToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavMovie(movieEntity, state) }
    }

    override fun setFavShows(tvShow: TvShow, state: Boolean) {
        val tvShowEntity = DataMapper.mapDomainShowToEntity(tvShow)
        appExecutors.diskIO().execute { localDataSource.setFavShow(tvShowEntity, state) }
    }

}