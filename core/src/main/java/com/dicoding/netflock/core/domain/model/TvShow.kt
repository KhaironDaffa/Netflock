package com.dicoding.netflock.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(
    var tvShowId: Int,

    var tvShowTitle: String,

    var tvShowPoster: String,

    var tvShowDesc: String,

    var tvShowDate: String,

    var favorite: Boolean = false
) : Parcelable
