package com.davidcuyas.rickandmortyapp.usecases.interactors

import com.davidcuyas.rickandmortyapp.data.repositories.EpisodeRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Episode

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.domain.entities.Location
import com.davidcuyas.rickandmortyapp.domain.entities.Origin
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetCharacterDetailByIdUseCaseTest {

    private val characterRepository: CharacterRepository = mockk()
    private val episodeRepository: EpisodeRepository = mockk()
    private lateinit var useCase: GetCharacterDetailByIdUseCase

    @Before
    fun setUp() {
        useCase = GetCharacterDetailByIdUseCase(characterRepository, episodeRepository)
    }

    @Test
    fun `Should return character detail DTO by id`() = runTest {
        val character = Character(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = Location(
                name = "Citadel of Ricks",
                url = "https://rickandmortyapi.com/api/location/3"
            ),
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf("https://rickandmortyapi.com/api/episode/1"),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )

        val episode = Episode(
            id = 1,
            name = "Pilot",
            airDate = "December 2, 2013",
            episode = "S01E01",
            characters = listOf(),
            url = "https://rickandmortyapi.com/api/episode/1",
            created = "2017-11-10T12:56:33.798Z"
        )

        val expectedResponse = CharacterDetailDto(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = Location(
                name = "Citadel of Ricks",
                url = "https://rickandmortyapi.com/api/location/3"
            ),
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf(
                Episode(
                    id = 1,
                    name = "Pilot",
                    airDate = "December 2, 2013",
                    episode = "S01E01",
                    characters = listOf(),
                    url = "https://rickandmortyapi.com/api/episode/1",
                    created = "2017-11-10T12:56:33.798Z"
                )
            ),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )

        coEvery { characterRepository.getById(1) } returns character
        coEvery { episodeRepository.getById(listOf(1)) } returns listOf(episode)

        val result = useCase(1)
        assertEquals(expectedResponse, result)
    }
}