package com.dicoding.netflock.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase


class MoviesViewModel @ViewModelInject constructor(netflockUseCase: NetflockUseCase) : ViewModel() {

    val movie = netflockUseCase.getAllMovies().asLiveData()

}