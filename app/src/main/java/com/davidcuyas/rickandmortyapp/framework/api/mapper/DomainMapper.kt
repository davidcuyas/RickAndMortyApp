package com.davidcuyas.rickandmortyapp.framework.api.mapper

import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.domain.entities.Location
import com.davidcuyas.rickandmortyapp.domain.entities.Origin
import com.davidcuyas.rickandmortyapp.framework.api.entities.CharacterDto

fun CharacterDto.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = Origin(
            name = this.origin.name,
            url = this.origin.url
        ),
        location = Location(
            name = this.location.name,
            url = this.location.url
        ),
        image = this.image,
        episode = this.episode,
        created = this.created,
        url = this.url
    )
}