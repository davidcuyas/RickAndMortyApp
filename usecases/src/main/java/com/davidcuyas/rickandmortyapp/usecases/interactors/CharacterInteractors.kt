package com.davidcuyas.rickandmortyapp.usecases.interactors

data class CharacterInteractors(
    val getAllCharacters: GetAllCharactersUseCase,
    val getCharacterDetailById: GetCharacterDetailByIdUseCase
)