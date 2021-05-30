package com.dicoding.netflock.favorite.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase

class FavShowsViewModel(netflockUseCase: NetflockUseCase) : ViewModel() {
    val favShow = netflockUseCase.getFavShows().asLiveData()
}