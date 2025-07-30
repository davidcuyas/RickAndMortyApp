package com.davidcuyas.rickandmortyapp.framework.di

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.data.repositories.EpisodeRepository
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
        characterRepository: CharacterRepository,
        episodeRepository: EpisodeRepository
    ) = CharacterInteractors(
        getAllCharacters = GetAllCharactersUseCase(characterRepository),
        getCharacterDetailById = GetCharacterDetailByIdUseCase(
            characterRepository,
            episodeRepository
        )
    )

}