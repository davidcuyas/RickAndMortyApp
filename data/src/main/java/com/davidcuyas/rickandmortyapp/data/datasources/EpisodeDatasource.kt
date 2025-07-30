package com.davidcuyas.rickandmortyapp.data.datasources

import com.davidcuyas.rickandmortyapp.domain.entities.Episode


interface EpisodeDatasource {
    suspend fun getById(id: Int): Episode?
}