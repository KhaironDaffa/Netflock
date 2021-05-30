package com.dicoding.netflock.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        var movieId: Int,

        @ColumnInfo(name = "movieTitle")
        var movieTitle: String,

        @ColumnInfo(name = "moviePoster")
        var moviePoster: String,

        @ColumnInfo(name = "movieDesc")
        var movieDesc: String,

        @ColumnInfo(name = "movieDate")
        var movieDate: String,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
)
