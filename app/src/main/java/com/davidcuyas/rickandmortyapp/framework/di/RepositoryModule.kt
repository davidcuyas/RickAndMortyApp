package com.davidcuyas.rickandmortyapp.framework.di

import com.davidcuyas.rickandmortyapp.data.datasources.CharacterDatasource
import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCharacterRepository(datasource: CharacterDatasource) =
        CharacterRepository(datasource
        )
}