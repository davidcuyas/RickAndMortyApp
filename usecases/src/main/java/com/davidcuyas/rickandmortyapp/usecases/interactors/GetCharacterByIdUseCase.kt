package com.davidcuyas.rickandmortyapp.usecases.interactors

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.usecases.interactors.base.GetByIdBaseUseCase

class GetCharacterDetailByIdUseCase(
    private val repository: CharacterRepository
): GetByIdBaseUseCase<Character, Int> {
    override suspend fun invoke(id: Int): Character? =
        repository.getById(id)
}