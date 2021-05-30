package com.dicoding.netflock.core.di

import com.dicoding.netflock.core.domain.repository.INetflockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(netflockRepository: com.dicoding.netflock.core.data.NetflockRepository): INetflockRepository
}