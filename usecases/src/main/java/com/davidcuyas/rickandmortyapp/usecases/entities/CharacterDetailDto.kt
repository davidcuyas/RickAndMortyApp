package com.davidcuyas.rickandmortyapp.usecases.entities

import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.domain.entities.Location
import com.davidcuyas.rickandmortyapp.domain.entities.Origin

data class CharacterDetailDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<Episode>,
    val url: String,
    val created: String
)
