package com.davidcuyas.rickandmortyapp.usecases.interactors.base

fun interface GetByIdBaseUseCase<T, I> {
    suspend operator fun invoke(id: I): T?
}