package com.dicoding.netflock.favorite.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase

class FavMoviesViewModel(netflockUseCase: NetflockUseCase) : ViewModel() {
    val favMovie = netflockUseCase.getFavMovies().asLiveData()
}