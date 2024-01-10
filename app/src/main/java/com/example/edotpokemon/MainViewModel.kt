package com.example.edotpokemon

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edotpokemon.data.repository.PokemonRepository
import com.example.edotpokemon.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {
    private val _pokemonData = MutableStateFlow<List<Pokemon>?>(null)
    val pokemonData: StateFlow<List<Pokemon>?> get() = _pokemonData

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemon().collect {
                _pokemonData.value = it
            }
        }
    }
}