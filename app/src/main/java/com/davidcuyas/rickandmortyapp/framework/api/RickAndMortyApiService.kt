package com.davidcuyas.rickandmortyapp.framework.api

import com.davidcuyas.rickandmortyapp.framework.api.entities.CharacterApiDto
import com.davidcuyas.rickandmortyapp.framework.api.entities.CharacterListResponseApiDto
import com.davidcuyas.rickandmortyapp.framework.api.entities.EpisodeApiDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int? = null): CharacterListResponseApiDto

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): CharacterApiDto

    @GET("episode/{ids}")
    suspend fun getEpisodesByMultipleId(@Path("ids") ids: String): List<EpisodeApiDto>
}