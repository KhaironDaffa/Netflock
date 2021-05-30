package com.dicoding.netflock.di

import com.dicoding.netflock.core.domain.usecase.NetflockInteractor
import com.dicoding.netflock.core.domain.usecase.NetflockUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideNetflockUseCase(netflockInteractor: NetflockInteractor): NetflockUseCase
}