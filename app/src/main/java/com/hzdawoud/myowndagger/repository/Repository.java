package com.hzdawoud.myowndagger.repository;

import com.hzdawoud.myowndagger.model.PokemonResponse;
import com.hzdawoud.myowndagger.network.PokemonApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {
    private PokemonApiService pokemonApiService;

    @Inject
    public Repository(PokemonApiService pokemonApiService) {
        this.pokemonApiService = pokemonApiService;
    }

    public Observable<PokemonResponse> getPokemons(){
        return pokemonApiService.getPokemons();
    }
}
