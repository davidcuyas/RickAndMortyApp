package com.davidcuyas.rickandmortyapp.presentation.ui.shared

import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.domain.entities.Location
import com.davidcuyas.rickandmortyapp.domain.entities.Origin
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto

val mockEpisodeList = listOf(
    Episode(
        id = 1,
        name = "Pilot",
        airDate = "December 2, 2013",
        episode = "S01E01",
        characters = listOf(),
        url = "https://rickandmortyapi.com/api/episode/1",
        created = "2017-11-10T12:56:33.798Z"
    ),
    Episode(
        id = 2,
        name = "Lawnmower Dog",
        airDate = "December 9, 2013",
        episode = "S01E02",
        characters = listOf(),
        url = "https://rickandmortyapi.com/api/episode/2",
        created = "2017-11-10T12:56:33.916Z"
    )
)

val mockCharacterDetail = CharacterDetailDto(
    id = 1,
    name = "Rick Sanchez",
    status = "Alive",
    species = "Human",
    type = "",
    gender = "",
    origin = Origin(
        name = "Earth (C-137)",
        url = "https://rickandmortyapi.com/api/location/1"
    ),
    location = Location(
        name = "Citadel of Ricks",
        url = "https://rickandmortyapi.com/api/location/3"
    ),
    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    episode = mockEpisodeList,
    url = "https://rickandmortyapi.com/api/character/1",
    created = "2017-11-04T18:48:46.250Z"
)

val mockCharacterList = listOf(
    CharacterListDto(
        id = 1,
        name = "Rick Sanchez",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        species = "Human",
        status = "Alive"
    ),
    CharacterListDto(
        id = 2,
        name = "Morty Smith",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        species = "Human",
        status = "Alive"
    ),
    CharacterListDto(
        id = 3,
        name = "Summer Smith",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        species = "Human",
        status = "Dead"
    ),
    CharacterListDto(
        id = 4,
        name = "Jerry Smith",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
        species = "Alien",
        status = "Unknown"
    ),
    CharacterListDto(
        id = 5,
        name = "Neva Scott",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
        species = "Human",
        status = "Alive"
    )
)

