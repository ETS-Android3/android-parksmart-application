package com.example.speechrecognition;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.speechrecognition.databinding.ActivityGmapsBinding;

public class GMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGmapsBinding binding;
    double lat;
    String longi;
    String lati;
    //String pspot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGmapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //String negNum = "-743.347";
        //Double num = Double.valueOf(negNum);
        //System.out.println("Negative number: " + num);

        //lat = Double.parseDouble(getIntent().getStringExtra("latitude"));
        lati = getIntent().getStringExtra("latitude");
        longi = getIntent().getStringExtra("latitude");
        //pspot = getIntent().getStringExtra("parking_spot");
        //System.out.println(lati);
        //longt = Double.parseDouble(getIntent().getStringExtra("longitude"));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


//        String negNum = "-743.347";
//        Double num = Double.valueOf(negNum);
//        System.out.println("Negative number: " + num);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(Double.valueOf(lati), -73.985664);
        //LatLng sydney = new LatLng(Double.valueOf(lati), Double.valueOf(longi));
        //LatLng sydney = new LatLng(Double.parseDouble(lati), Double.parseDouble(longi));
        //LatLng sydney = new LatLng(lat, longt);
        //System.out.println(Double.parseDouble(lati));
        //System.out.println(Double.parseDouble(longi));
        mMap.addMarker(new MarkerOptions().position(sydney).title("marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}