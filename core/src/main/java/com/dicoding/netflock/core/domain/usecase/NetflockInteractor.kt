package com.dicoding.netflock.core.domain.usecase

import com.dicoding.netflock.core.domain.model.Movie
import com.dicoding.netflock.core.domain.model.TvShow
import com.dicoding.netflock.core.domain.repository.INetflockRepository
import javax.inject.Inject

class NetflockInteractor @Inject constructor(private val netflockRepository: INetflockRepository): NetflockUseCase {

    override fun getAllMovies() = netflockRepository.getAllMovies()

    override fun getAllTvShows() = netflockRepository.getAllTvShows()

    override fun getFavMovies() = netflockRepository.getFavMovies()

    override fun getFavShows() = netflockRepository.getFavShows()

    override fun setFavMovies(movieEntity: Movie, state: Boolean) = netflockRepository.setFavMovies(movieEntity, state)

    override fun setFavShows(tvShowEntity: TvShow, state: Boolean) = netflockRepository.setFavShows(tvShowEntity, state)
}