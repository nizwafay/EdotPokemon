package com.example.edotpokemon.core

import com.example.edotpokemon.data.api.PokemonApi
import com.example.edotpokemon.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return createRetrofitClient().create(PokemonApi::class.java)
    }

    @Provides
    fun providePokemonRepository(pokemonApi: PokemonApi): PokemonRepository {
        return PokemonRepository(pokemonApi)
    }
}