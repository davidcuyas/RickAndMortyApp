package com.davidcuyas.rickandmortyapp.data.repositories

import com.davidcuyas.rickandmortyapp.data.datasources.CharacterDatasource
import com.davidcuyas.rickandmortyapp.data.repositories.base.PaginatedBaseRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Character

open class CharacterRepository(
    private val datasource: CharacterDatasource
) : PaginatedBaseRepository<Character, Int> {
    override suspend fun get(): List<Character> =
        datasource.get()

    override suspend fun get(page: Int): List<Character> =
        datasource.get(page)

    override suspend fun getById(id: Int): Character? =
        datasource.getById(id)
}