import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.domain.entities.Location
import com.davidcuyas.rickandmortyapp.domain.entities.Origin
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.GetAllCharactersUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAllCharactersUseCaseTest {

    private val repository: CharacterRepository = mockk()
    private lateinit var useCase: GetAllCharactersUseCase

    @Before
    fun setUp() {
        useCase = GetAllCharactersUseCase(repository)
    }

    @Test
    fun `Should return list of character DTOs`() = runTest {
        val characters = listOf(
            Character(
                id = 1,
                name = "Rick Sanchez",
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                species = "Human",
                status = "Alive",
                type = "",
                gender = "Male",
                origin = Origin("Earth (C-137)", "https://rickandmortyapi.com/api/location/1"),
                location = Location("Citadel of Ricks", "https://rickandmortyapi.com/api/location/3"),
                episode = listOf(),
                url = "https://rickandmortyapi.com/api/character/1",
                created = "2017-11-04T18:48:46.250Z"
            ),
            Character(
                id = 2,
                name = "Morty Smith",
                image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                species = "Human",
                status = "Alive",
                type = "",
                gender = "Male",
                origin = Origin("unknown", ""),
                location = Location("Citadel of Ricks", "https://rickandmortyapi.com/api/location/3"),
                episode = listOf(),
                url = "https://rickandmortyapi.com/api/character/2",
                created = "2017-11-04T18:50:21.651Z"
            )
        )

        val expectedResponse = listOf(
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
            )
        )

        coEvery { repository.get(any()) } returns characters

        val result = useCase(page = 1)
        assertEquals(expectedResponse, result)
    }
}