package com.example.cinemaapp;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CinemaDetailsActivity extends FragmentActivity implements OnMapReadyCallback {
    private TextView addressText;
    private GoogleMap map;
    private Button button;
    private Cinema cinema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_details);
        Toolbar toolbar = findViewById(R.id.toolbar);

        Bundle bundle=getIntent().getExtras();

        if(bundle!=null){
            cinema=(Cinema)bundle.getSerializable("cinema");
            toolbar.setTitle(cinema.getName());
            addressText=findViewById(R.id.addressView);
            addressText.setText(cinema.getAddress());

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment);
            mapFragment.getMapAsync(this);
        }

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CinemaDetailsActivity.this,MovieListActivity.class);
                intent.putExtra("whichCinema",cinema);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        LatLng location=new LatLng(cinema.getLatitude(),cinema.getLongitude());
        map.addMarker(new MarkerOptions().position(location).title(cinema.getName()+" marker"));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
