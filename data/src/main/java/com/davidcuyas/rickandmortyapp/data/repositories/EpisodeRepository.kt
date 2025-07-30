package com.davidcuyas.rickandmortyapp.data.repositories

import com.davidcuyas.rickandmortyapp.data.datasources.EpisodeDatasource
import com.davidcuyas.rickandmortyapp.domain.entities.Episode

open class EpisodeRepository(
    private val datasource: EpisodeDatasource
) {
    suspend fun getById(idList: List<Int>): List<Episode> =
        datasource.getById(idList)
}