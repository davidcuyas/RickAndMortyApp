package com.davidcuyas.rickandmortyapp.usecases.interactors.base

interface GetPaginatedListBaseUseCase<T> {
    suspend operator fun invoke(page: Int): List<T>
}