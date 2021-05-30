package com.dicoding.netflock.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Shows")
data class TvShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "showId")
        var tvShowId: Int,

        @ColumnInfo(name = "showTitle")
        var tvShowTitle: String,

        @ColumnInfo(name = "showPoster")
        var tvShowPoster: String,

        @ColumnInfo(name = "showDesc")
        var tvShowDesc: String,

        @ColumnInfo(name = "showDate")
        var tvShowDate: String,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
)
