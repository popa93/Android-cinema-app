package com.example.cinemaapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Cinema> cinemaList=new ArrayList<>();
    private RecyclerView myRecycler;
    private RecyclerView.LayoutManager myLayoutManager;
    private CinemaAdapter myCinemaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createCinemaList(cinemaList);
        myLayoutManager=new LinearLayoutManager(this);
        myCinemaAdapter=new CinemaAdapter(cinemaList);

        myRecycler=findViewById(R.id.myRecycler);
        myRecycler.setLayoutManager(myLayoutManager);
        myRecycler.setAdapter(myCinemaAdapter);
        myRecycler.setHasFixedSize(true);

        myCinemaAdapter.setClickListener(new ClickListener() {      //aici e o instanta a interfetei mele de click listener
            @Override
            public void OnItemClick(Cinema cinema) {
                Intent intent=new Intent(MainActivity.this,CinemaDetailsActivity.class);
                intent.putExtra("cinema", cinema);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void createCinemaList(List<Cinema>list){    //with random lat&long

        Cinema cinema1=new Cinema("1. Mures cinema","Zagazului nr.8",45,-120);
        Cinema cinema2=new Cinema("2. Cluj cinema","Gheorghe Dima nr.47",30,90);
        Cinema cinema3=new Cinema("3. Blaj cinema","Semanatorului nr.9",30,-162);
        Cinema cinema4=new Cinema("4. Brasov cinema","Crizantemei nr.128",13,161);
        Cinema cinema5=new Cinema("5. Sibiu cinema","Pomicultorilor nr.31",44,120);
        Cinema cinema6=new Cinema("6. Bistrita cinema","Parangului nr.11",21,58);
        Cinema cinema7=new Cinema("7. Timisoara cinema","Vestului nr.1",23,-150);
        Cinema cinema8=new Cinema("8. Oradea cinema","Pandurilor nr.66",24,-160);
        Cinema cinema9=new Cinema("9. Arad cinema","Gh.Doja nr.21",72,66);

        list.add(cinema1);
        list.add(cinema2);
        list.add(cinema3);
        list.add(cinema4);
        list.add(cinema5);
        list.add(cinema6);
        list.add(cinema7);
        list.add(cinema8);
        list.add(cinema9);
    }
}