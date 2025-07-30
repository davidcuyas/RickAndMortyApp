package com.davidcuyas.rickandmortyapp.framework.api.datasources

import com.davidcuyas.rickandmortyapp.data.datasources.EpisodeDatasource
import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.framework.api.RickAndMortyApiService
import com.davidcuyas.rickandmortyapp.framework.api.mapper.toDomain
import javax.inject.Inject

class RemoteEpisodeDatasource @Inject constructor(
    private val apiService: RickAndMortyApiService
) : EpisodeDatasource {

    override suspend fun getById(id: Int): Episode? {
        return try {
            apiService.getEpisodeById(id).toDomain()
        } catch (e: Exception) {
            // TODO: Handle exceptions
            null
        }
    }
}