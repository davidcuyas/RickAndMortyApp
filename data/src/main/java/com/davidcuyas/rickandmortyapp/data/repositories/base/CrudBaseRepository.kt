package com.davidcuyas.rickandmortyapp.data.repositories.base

interface CrudBaseRepository<T, I> {
    suspend fun insert(item: T)
    suspend fun insertAll(items: List<T>)
    suspend fun get(): List<T>
    suspend fun get(page: Int): List<T>
    suspend fun getById(id: I): T?
    suspend fun update(item: T)
    suspend fun delete(item: T)
    suspend fun deleteAll()
}