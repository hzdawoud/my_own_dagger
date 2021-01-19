package com.hzdawoud.myowndagger.network;

import com.hzdawoud.myowndagger.model.PokemonResponse;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiService {

    /* We're wrapping the methods with RXJava so we can execute them in the background thread
    that's why we use Observable!
    */
    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();

}

