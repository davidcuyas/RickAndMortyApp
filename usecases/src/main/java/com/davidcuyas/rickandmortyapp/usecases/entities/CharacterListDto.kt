package com.davidcuyas.rickandmortyapp.usecases.entities

data class CharacterListDto(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val species: String,
    val status: String
)