package com.example.edotpokemon.data.model

import com.example.edotpokemon.domain.model.Pokemon
import com.squareup.moshi.Json

data class PokemonApiResponse(
    @Json(name = "count") val totalCount: Int?,
    @Json(name = "next") val next: String?,
    @Json(name = "previous") val previous: String?,
    @Json(name = "results") val results: List<Pokemon>,
)