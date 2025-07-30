package com.davidcuyas.rickandmortyapp.framework.api.datasources

import com.davidcuyas.rickandmortyapp.data.datasources.EpisodeDatasource
import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.framework.api.RickAndMortyApiService
import com.davidcuyas.rickandmortyapp.framework.api.mapper.toDomain
import javax.inject.Inject

class RemoteEpisodeDatasource @Inject constructor(
    private val apiService: RickAndMortyApiService
) : EpisodeDatasource {

    override suspend fun getById(idList: List<Int>): List<Episode> {
        return try {
            val idListString = if(idList.count() > 1) {
                idList.joinToString(",")
            }else {
                idList.toString()
            }

            val episodes = mutableListOf<Episode>()
            val apiEpisodes = apiService.getEpisodesByMultipleId(idListString)
            apiEpisodes.forEach {
                episodes.add(it.toDomain())
            }
            episodes
        } catch (e: Exception) {
            throw e
        }
    }
}