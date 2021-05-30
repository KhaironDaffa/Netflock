package com.dicoding.netflock.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(

        @field:SerializedName("results")
        val movieResults: List<MoviesItems>
) : Parcelable

@Parcelize
data class MoviesItems(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("release_date")
        val releaseDate: String,

) : Parcelable