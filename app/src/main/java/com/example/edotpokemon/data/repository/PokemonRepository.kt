package com.example.edotpokemon.data.repository

import com.example.edotpokemon.data.api.PokemonApi
import com.example.edotpokemon.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(private val api: PokemonApi) {
    suspend fun getPokemon(): Flow<List<Pokemon>> {
        val fetchResult = api.getPokemon().results
        return flowOf(fetchResult)
    }
}