package com.dicoding.netflock.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.dicoding.netflock.core.domain.model.Movie
import com.dicoding.netflock.core.domain.model.TvShow
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase

class DetailsViewModel @ViewModelInject constructor(private val netflockUseCase: NetflockUseCase) : ViewModel() {
    fun setFavMovies(movie: Movie, newState: Boolean) = netflockUseCase.setFavMovies(movie, newState)

    fun setFavShows(tvShow: TvShow, newState: Boolean) = netflockUseCase.setFavShows(tvShow, newState)
}