package com.davidcuyas.rickandmortyapp.data.datasources

import com.davidcuyas.rickandmortyapp.domain.entities.Episode


interface EpisodeDatasource {
    suspend fun getById(idList: List<Int>): List<Episode>
}