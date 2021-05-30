package com.dicoding.netflock.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase
import com.dicoding.netflock.favorite.movies.FavMoviesViewModel
import com.dicoding.netflock.favorite.tvshows.FavShowsViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val netflockUseCase: NetflockUseCase) :
    ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavMoviesViewModel::class.java) -> {
                FavMoviesViewModel(netflockUseCase) as T
            }

            modelClass.isAssignableFrom(FavShowsViewModel::class.java) -> {
                FavShowsViewModel(netflockUseCase) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}