package com.davidcuyas.rickandmortyapp.presentation.viewmodels.character

import android.app.Application
import app.cash.turbine.test
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.CharacterInteractors
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CharacterListViewModelTest {
    private val interactors: CharacterInteractors = mockk()
    private lateinit var viewModel: CharacterListViewModel
    private val dispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        val context = mockk<Application>(relaxed = true)
        Dispatchers.setMain(dispatcher)

        coEvery { interactors.getAllCharacters(any()) } returns listOf(
            CharacterListDto(
                id = 1,
                name = "Rick Sanchez",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                species = "Human",
                status = "Alive"
            )
        )

        viewModel = CharacterListViewModel(
            application = context,
            interactors = interactors,
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Should emit UiState Success when characters are loaded`() = runTest {
        viewModel.uiState().test {
            val state = awaitItem()
            assertTrue(state is UiState.Success)
            cancelAndIgnoreRemainingEvents()
        }
    }
}