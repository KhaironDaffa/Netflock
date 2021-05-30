package com.dicoding.netflock.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(

        @field:SerializedName("results")
        val showResults: List<ShowsItems>
) : Parcelable

@Parcelize
data class ShowsItems(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("name")
        val title: String,

        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("first_air_date")
        val releaseDate: String

) : Parcelable