package com.davidcuyas.rickandmortyapp.framework.di

import com.davidcuyas.rickandmortyapp.data.datasources.CharacterDatasource
import com.davidcuyas.rickandmortyapp.framework.api.RickAndMortyApiService
import com.davidcuyas.rickandmortyapp.framework.api.datasources.RemoteCharacterDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {

    @Provides
    fun provideCharacterDatasource(apiService: RickAndMortyApiService): CharacterDatasource =
        RemoteCharacterDatasource(apiService)

}