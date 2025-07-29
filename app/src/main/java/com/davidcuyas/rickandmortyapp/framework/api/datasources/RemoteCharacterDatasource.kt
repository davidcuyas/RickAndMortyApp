package com.davidcuyas.rickandmortyapp.framework.api.datasources

import com.davidcuyas.rickandmortyapp.data.datasources.CharacterDatasource
import com.davidcuyas.rickandmortyapp.framework.api.RickAndMortyApiService
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.framework.api.mapper.toDomain
import javax.inject.Inject

class RemoteCharacterDatasource @Inject constructor(
    private val apiService: RickAndMortyApiService
) : CharacterDatasource {

    override suspend fun insert(item: Character) {
        throw UnsupportedOperationException("Creating characters is not supported by this API.")
    }

    override suspend fun insertAll(items: List<Character>) {
        throw UnsupportedOperationException("Creating characters is not supported by this API.")
    }

    override suspend fun get(): List<Character> {
        return get(page = 1)
    }


    suspend fun get(page: Int?): List<Character> {
        return try {
            apiService.getAllCharacters(page = page).results.map { it.toDomain() }
        } catch (e: Exception) {
            // TODO: Handle exceptions
            emptyList()
        }
    }

    override suspend fun getById(id: Int): Character? {
        return try {
            apiService.getCharacterById(id).toDomain()
        } catch (e: Exception) {
            // TODO: Handle exceptions
            null
        }
    }

    override suspend fun update(item: Character) {
        throw UnsupportedOperationException("Updating characters is not supported by this API.")
    }

    override suspend fun delete(item: Character) {
        throw UnsupportedOperationException("Deleting characters is not supported by this API.")
    }

    override suspend fun deleteAll() {
        throw UnsupportedOperationException("Deleting characters is not supported by this API.")
    }
}