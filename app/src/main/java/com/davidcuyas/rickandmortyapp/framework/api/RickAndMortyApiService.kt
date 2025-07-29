package com.davidcuyas.rickandmortyapp.framework.api

import com.davidcuyas.rickandmortyapp.framework.api.entities.CharacterDto
import com.davidcuyas.rickandmortyapp.framework.api.entities.CharacterListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int? = null): CharacterListResponseDto

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): CharacterDto

}