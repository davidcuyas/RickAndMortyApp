package com.davidcuyas.rickandmortyapp.framework.api.entities

import com.google.gson.annotations.SerializedName

data class CharacterApiDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: OriginApiDto,
    @SerializedName("location") val location: LocationApiDto,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)

data class OriginApiDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class LocationApiDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class CharacterListResponseApiDto(
    @SerializedName("info") val info: InfoApiDto,
    @SerializedName("results") val results: List<CharacterApiDto>
)

data class InfoApiDto(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)