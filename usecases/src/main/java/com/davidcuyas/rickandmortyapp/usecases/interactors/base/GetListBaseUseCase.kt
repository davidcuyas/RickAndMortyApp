package com.davidcuyas.rickandmortyapp.usecases.interactors.base

interface GetListBaseUseCase<T> {
    suspend operator fun invoke(): List<T>
}