package com.dicoding.netflock.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [com.dicoding.netflock.core.data.source.local.entity.MovieEntity::class, com.dicoding.netflock.core.data.source.local.entity.TvShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class NetflockDatabase : RoomDatabase() {

    abstract fun netflockDao(): NetflockDao

}