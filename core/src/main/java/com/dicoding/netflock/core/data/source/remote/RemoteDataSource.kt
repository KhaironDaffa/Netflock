package com.dicoding.netflock.core.data.source.remote

import android.util.Log
import com.dicoding.netflock.core.data.source.remote.api.ApiResponse
import com.dicoding.netflock.core.data.source.remote.api.ApiService
import com.dicoding.netflock.core.data.source.remote.response.MoviesItems
import com.dicoding.netflock.core.data.source.remote.response.ShowsItems
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    suspend fun getAllMovies(): Flow<ApiResponse<List<MoviesItems>>> {

        return flow {
            try {
                val response = apiService.getMovieList()
                val dataArray = response.movieResults
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.movieResults))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getAllTvShows(): Flow<ApiResponse<List<ShowsItems>>> {
        return flow {
            try {
                val response = apiService.getShowList()
                val dataArray = response.showResults
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.showResults))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}