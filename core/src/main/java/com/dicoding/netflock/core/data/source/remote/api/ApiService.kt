package com.dicoding.netflock.core.data.source.remote.api

import com.dicoding.netflock.core.data.source.remote.response.MovieResponse
import com.dicoding.netflock.core.data.source.remote.response.TvShowResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("discover/movie?api_key=bf1f0b8026b602e98acc73dedd47f8a8&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate")
    suspend fun getMovieList(): MovieResponse

    @GET("discover/tv?api_key=bf1f0b8026b602e98acc73dedd47f8a8&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate")
    suspend fun getShowList(): TvShowResponse

    @GET("movie/{id}?api_key=bf1f0b8026b602e98acc73dedd47f8a8&language=en-US")
    suspend fun getMovieDetails(@Path("id") id : String): MovieResponse

    @GET("tv/{id}?api_key=bf1f0b8026b602e98acc73dedd47f8a8&language=en-US")
    suspend fun getShowDetails(@Path("id") id : String): TvShowResponse

}