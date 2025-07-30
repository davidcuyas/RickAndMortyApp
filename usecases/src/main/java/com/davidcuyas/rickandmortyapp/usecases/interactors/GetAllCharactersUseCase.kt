package com.davidcuyas.rickandmortyapp.usecases.interactors

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.base.GetPaginatedListBaseUseCase

class GetAllCharactersUseCase(
    private val repository: CharacterRepository
): GetPaginatedListBaseUseCase<CharacterListDto> {
    override suspend fun invoke(page: Int): List<CharacterListDto> {
        val characterListDto = mutableListOf<CharacterListDto>()
        val characterList = repository.get(page)

        characterList.forEach{ character ->
            characterListDto.add(
                CharacterListDto(
                    id = character.id,
                    name = character.name,
                    imageUrl = character.image,
                    species = character.species,
                    status = character.status
                )
            )
        }

        return characterListDto
    }

}