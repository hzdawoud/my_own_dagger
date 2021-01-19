package com.hzdawoud.myowndagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hzdawoud.myowndagger.adapter.RingsAdapter;
import com.hzdawoud.myowndagger.model.Ring;
import com.hzdawoud.myowndagger.viewmodel.RingViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private RingViewModel viewModel;
    private RecyclerView recyclerView;
    private RingsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.pokemon_recyclerView);
        adapter = new RingsAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(RingViewModel.class);

        viewModel.getPokemons();

        viewModel.getPokemonList().observe(this, new Observer<ArrayList<Ring>>() {
            @Override
            public void onChanged(ArrayList<Ring> rings) {
                adapter.setList(rings);
            }
        });
    }
}