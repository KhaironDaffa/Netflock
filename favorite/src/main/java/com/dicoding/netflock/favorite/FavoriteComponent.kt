package com.dicoding.netflock.favorite

import android.content.Context
import com.dicoding.netflock.di.FavoriteModuleDependencies
import com.dicoding.netflock.favorite.movies.FavoriteMoviesFragment
import com.dicoding.netflock.favorite.tvshows.FavoriteTvShowsFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoriteActivity)
    fun inject(fragment: FavoriteMoviesFragment)
    fun inject(fragment: FavoriteTvShowsFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}