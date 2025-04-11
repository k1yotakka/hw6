package com.example.homework6

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideMyUseCase(repository: MyRepository): MyUseCase {
        return MyUseCase(repository)
    }
}
