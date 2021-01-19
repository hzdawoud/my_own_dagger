package com.hzdawoud.myowndagger.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hzdawoud.myowndagger.model.Ring;
import com.hzdawoud.myowndagger.model.RingResponse;
import com.hzdawoud.myowndagger.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class RingViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<ArrayList<Ring>> pokemonList = new MutableLiveData<>();
    private LiveData<List<Ring>> favList = null;

    public LiveData<List<Ring>> getFavList() {
        return favList;
    }

    @ViewModelInject
    public RingViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Ring>> getPokemonList() {
        return pokemonList;
    }


    @SuppressLint("CheckResult")
    public void getPokemons() {
        Log.e("gg", "here");

        repository.getRings()
                .subscribeOn(Schedulers.io())
                .map(new Function<RingResponse, ArrayList<Ring>>() {
                    @Override
                    public ArrayList<Ring> apply(RingResponse ringResponse) throws Throwable {
                        ArrayList<Ring> list = ringResponse.getDocs();
                        Log.e("gg", list.size()+"");
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> pokemonList.setValue(result),
                        error -> Log.e("viwModel", error.getMessage()));
    }

}
