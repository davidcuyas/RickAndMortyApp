package com.davidcuyas.rickandmortyapp.framework.di

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.usecases.interactors.CharacterInteractors
import com.davidcuyas.rickandmortyapp.usecases.interactors.GetAllCharactersUseCase
import com.davidcuyas.rickandmortyapp.usecases.interactors.GetCharacterDetailByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCharacterUseCases(
        repository: CharacterRepository
    ) = CharacterInteractors(
        getAllCharacters = GetAllCharactersUseCase(repository),
        getCharacterDetailById = GetCharacterDetailByIdUseCase(repository)
    )

}