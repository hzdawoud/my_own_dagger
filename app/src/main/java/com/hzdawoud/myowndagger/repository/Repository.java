package com.hzdawoud.myowndagger.repository;

import com.hzdawoud.myowndagger.model.RingResponse;
import com.hzdawoud.myowndagger.network.RingApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {
    private RingApiService ringApiService;

    @Inject
    public Repository(RingApiService ringApiService) {
        this.ringApiService = ringApiService;
    }

    public Observable<RingResponse> getRings(){
        return ringApiService.getRings();
    }
}
