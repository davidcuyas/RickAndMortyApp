package com.davidcuyas.rickandmortyapp.presentation.viewmodels.character

import app.cash.turbine.test
import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.domain.entities.Location
import com.davidcuyas.rickandmortyapp.domain.entities.Origin
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.CharacterInteractors
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDetailViewModelTest {

    private val dispatcher = StandardTestDispatcher()
    private val interactors: CharacterInteractors = mockk()
    private lateinit var viewModel: CharacterDetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)

        val detail = CharacterDetailDto(
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

        coEvery { interactors.getCharacterDetailById(1) } returns detail

        viewModel = CharacterDetailViewModel(
            application = mockk(relaxed = true),
            interactors = interactors
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Should emit UiState Success with character details`() = runTest {
        viewModel.getCharacterDetailById(1)
        advanceUntilIdle()

        viewModel.uiState().test {
            val state = awaitItem()
            assertTrue(state is UiState.Success)
            val data = (state as UiState.Success).data
            assertEquals("Rick Sanchez", data?.name)
            cancelAndIgnoreRemainingEvents()
        }
    }
}