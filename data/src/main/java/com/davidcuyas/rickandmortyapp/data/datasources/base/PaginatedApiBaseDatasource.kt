package com.davidcuyas.rickandmortyapp.data.datasources.base

interface PaginatedApiBaseDatasource<T, I> {
    suspend fun get(): List<T>
    suspend fun get(page: Int): List<T>
    suspend fun getById(id: I): T?
}