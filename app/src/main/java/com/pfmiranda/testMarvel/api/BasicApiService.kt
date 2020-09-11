package com.pfmiranda.testMarvel.api


import com.pfmiranda.testMarvel.models.Characters
import retrofit2.http.GET

interface BasicApiService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(): Characters

}