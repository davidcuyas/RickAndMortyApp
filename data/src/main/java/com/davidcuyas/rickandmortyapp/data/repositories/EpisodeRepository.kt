package com.davidcuyas.rickandmortyapp.data.repositories

import com.davidcuyas.rickandmortyapp.data.datasources.EpisodeDatasource
import com.davidcuyas.rickandmortyapp.domain.entities.Episode

open class EpisodeRepository(
    private val datasource: EpisodeDatasource
) {
    suspend fun getById(id: Int): Episode? =
        datasource.getById(id)
}