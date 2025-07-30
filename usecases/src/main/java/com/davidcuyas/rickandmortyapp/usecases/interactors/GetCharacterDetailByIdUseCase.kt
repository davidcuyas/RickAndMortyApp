package com.davidcuyas.rickandmortyapp.usecases.interactors

import com.davidcuyas.rickandmortyapp.data.repositories.CharacterRepository
import com.davidcuyas.rickandmortyapp.data.repositories.EpisodeRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.base.GetByIdBaseUseCase

class GetCharacterDetailByIdUseCase(
    private val characterRepository: CharacterRepository,
    private val episodeRepository: EpisodeRepository
): GetByIdBaseUseCase<CharacterDetailDto, Int> {

    override suspend fun invoke(id: Int): CharacterDetailDto? {
        val characterDetail = characterRepository.getById(id) ?: return null

        val episodes = mutableListOf<Episode>()
        characterDetail.episode.forEach { episodeUrl ->
            val episodeId = getEpisodeIdFromUrl(episodeUrl)

            if(episodeId != null){
                val episode = episodeRepository.getById(episodeId)
                if(episode != null){
                    episodes.add(episode)
                }
            }
        }

        return CharacterDetailDto(
            id = characterDetail.id,
            name = characterDetail.name,
            status = characterDetail.status,
            species = characterDetail.species,
            type = characterDetail.type,
            gender = characterDetail.gender,
            origin = characterDetail.origin,
            location = characterDetail.location,
            image = characterDetail.image,
            episode = episodes,
            url = characterDetail.url,
            created = characterDetail.created
        )
    }

    private fun getEpisodeIdFromUrl(url: String): Int? {
        return url.trimEnd('/')
            .substringAfterLast('/')
            .takeIf { it.isNotBlank() }?.toInt()
    }

}