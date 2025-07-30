package com.davidcuyas.rickandmortyapp.data.repositories.base

interface PaginatedBaseRepository<T, I> {
    suspend fun get(): List<T>
    suspend fun get(page: Int): List<T>
    suspend fun getById(id: I): T?
}