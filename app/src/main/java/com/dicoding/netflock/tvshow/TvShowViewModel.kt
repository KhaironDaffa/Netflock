package com.dicoding.netflock.tvshow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase


class TvShowViewModel @ViewModelInject constructor(netflockUseCase: NetflockUseCase) : ViewModel() {

    val show = netflockUseCase.getAllTvShows().asLiveData()
}