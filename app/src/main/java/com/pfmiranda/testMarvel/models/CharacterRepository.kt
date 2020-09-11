package com.pfmiranda.testMarvel.models

import com.pfmiranda.testMarvel.api.BasicApiService
import org.koin.dsl.module


val marvelRepositoryModule = module {
    factory { CharacterRepository(get()) }
}

class CharacterRepository(private val marvelApi: BasicApiService) {
    suspend fun getCharacters() = marvelApi.getCharacters()
}