package com.dicoding.netflock.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var movieId: Int,

    var movieTitle: String,

    var moviePoster: String,

    var movieDesc: String,

    var movieDate: String,

    var favorite: Boolean = false
) : Parcelable
