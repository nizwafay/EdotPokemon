package com.example.edotpokemon.data.api

import com.example.edotpokemon.data.model.PokemonApiResponse
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon?offset=0&limit=10")
    suspend fun getPokemon(): PokemonApiResponse
}