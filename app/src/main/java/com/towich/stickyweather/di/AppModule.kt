package com.towich.stickyweather.di

import com.towich.stickyweather.data.repository.MainRepository
import com.towich.stickyweather.data.repository.MainRepositoryImpl
import com.towich.stickyweather.data.source.SessionStorage
import com.towich.stickyweather.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        apiService: ApiService,
        sessionStorage: SessionStorage
    ): MainRepository {
        return MainRepositoryImpl(
            apiService = apiService,
            sessionStorage = sessionStorage
        )
    }

    @Provides
    @Singleton
    fun provideSessionStorage(): SessionStorage {
        return SessionStorage()
    }
}