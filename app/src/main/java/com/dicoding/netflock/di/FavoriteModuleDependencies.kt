package com.dicoding.netflock.di

import com.dicoding.netflock.core.domain.usecase.NetflockUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FavoriteModuleDependencies {

    fun netflockUseCase(): NetflockUseCase
}