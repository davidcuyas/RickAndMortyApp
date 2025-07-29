package com.davidcuyas.rickandmortyapp.data.repositories

import com.davidcuyas.rickandmortyapp.data.datasources.CharacterDatasource
import com.davidcuyas.rickandmortyapp.data.repositories.base.CrudBaseRepository
import com.davidcuyas.rickandmortyapp.domain.entities.Character

open class CharacterRepository(
    private val datasource: CharacterDatasource
) : CrudBaseRepository<Character, Int> {
    override suspend fun insert(item: Character) =
        datasource.insert(item)

    override suspend fun insertAll(items: List<Character>) =
        datasource.insertAll(items)

    override suspend fun get(): List<Character> =
        datasource.get()

    override suspend fun get(page: Int): List<Character> =
        datasource.get(page)

    override suspend fun deleteAll() =
        datasource.deleteAll()

    override suspend fun delete(item: Character) =
        datasource.delete(item)

    override suspend fun update(item: Character) =
        datasource.update(item)

    override suspend fun getById(id: Int): Character? =
        datasource.getById(id)
}