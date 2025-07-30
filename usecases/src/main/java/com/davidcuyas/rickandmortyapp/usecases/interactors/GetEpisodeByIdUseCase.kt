package com.davidcuyas.rickandmortyapp.usecases.interactors

import com.davidcuyas.rickandmortyapp.data.repositories.EpisodeRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.usecases.interactors.base.GetByIdBaseUseCase

class GetEpisodeByIdUseCase(
    private val repository: EpisodeRepository
): GetByIdBaseUseCase<Episode, Int> {
    override suspend fun invoke(id: Int): Episode? =
        repository.getById(id)
}