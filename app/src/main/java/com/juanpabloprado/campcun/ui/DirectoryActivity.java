package com.juanpabloprado.campcun.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.juanpabloprado.campcun.R;
import com.juanpabloprado.campcun.adapters.PlaceAdapter;
import com.juanpabloprado.campcun.model.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DirectoryActivity extends ActionBarActivity {

    @InjectView(R.id.directoryRecyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        ButterKnife.inject(this);

        Map<String, Double> placePrices = new HashMap<>();
        placePrices.put("Hol-box", 50.2);
        placePrices.put("Isla blanca", 0.0);
        placePrices.put("Akumal", null);

        List<Place> places = new ArrayList<>();
        for(Map.Entry<String, Double> placePrice : placePrices.entrySet()) {
            places.add( new Place(placePrice.getKey(), placePrice.getValue(), 21.155783, -86.840402, "http://lorempixel.com/400/300"));
        }
        PlaceAdapter adapter = new PlaceAdapter(this, places);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
    }

    @OnClick(R.id.todoButton)
    public void startMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.mapButton)
    public void startMapActivity(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}
