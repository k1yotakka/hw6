package com.example.homework6

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): MyRepository {
        return MyRepositoryImpl(apiService)
    }
}