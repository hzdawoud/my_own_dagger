package com.hzdawoud.myowndagger.network;

import com.hzdawoud.myowndagger.model.RingResponse;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface RingApiService {

    /* We're wrapping the methods with RXJava so we can execute them in the background thread
    that's why we use Observable!
    */
    @GET("book")
    Observable<RingResponse> getRings();

}

