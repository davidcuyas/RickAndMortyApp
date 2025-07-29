package com.davidcuyas.rickandmortyapp.usecases.interactors

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.base.GetListBaseUseCase

class GetAllCharactersUseCase(
    private val repository: CharacterRepository
): GetListBaseUseCase<CharacterListDto> {
    override suspend fun invoke(): List<CharacterListDto> {
        val characterListDto = mutableListOf<CharacterListDto>()
        val characterList = repository.get()

        characterList.forEach{ character ->
            characterListDto.add(
                CharacterListDto(
                    name = character.name
                )
            )

        }


        return characterListDto
    }

}