package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;


import java.util.ArrayList;
import java.util.List;

public class heat_map extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private HeatmapTileProvider mProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( heat_map.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add heat map
        addHeatMap();
    }

    private void addHeatMap() {
        List<LatLng> locations = new ArrayList<>();

        // Add your data points (latitude and longitude)
        locations.add(new LatLng(37.7749, -122.4194)); // San Francisco
        locations.add(new LatLng(34.0522, -118.2437)); // Los Angeles
        locations.add(new LatLng(40.7128, -74.0060));  // New York

        // Create the heat map provider
        mProvider = new HeatmapTileProvider.Builder()
                .data(locations)
                .build();

        // Add overlay
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(mProvider));

        // Move the camera to a zoomed-in area
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.7749, -122.4194), 10));

    }
}