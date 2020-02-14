package com.example.cinemaapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    private List<Movie> myMovieList=new ArrayList<>();
    private RecyclerView myRecycler;
    private RecyclerView.LayoutManager myManager;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createList(myMovieList);

        myManager=new LinearLayoutManager(this);
        adapter=new MovieAdapter(myMovieList);
        myRecycler=findViewById(R.id.myRecycler2);
        myRecycler.setLayoutManager(myManager);
        myRecycler.setAdapter(adapter);
        myRecycler.setHasFixedSize(true);

        Bundle bundle=getIntent().getExtras();

        final Cinema myCinema=(Cinema)bundle.getSerializable("whichCinema");

        adapter.setClickListener(new ClickListenerMovie() {
            @Override
            public void OnItemClick(Movie movie) {
                Intent intent=new Intent(MovieListActivity.this,MovieDetailsActivity.class);
                intent.putExtra("movie",movie);
                intent.putExtra("cinema",myCinema);
                startActivity(intent);
            }
        });
    }

    private void createList(List<Movie> list){

        Bundle bundle=getIntent().getExtras();
        Cinema cinemaClicked=(Cinema)bundle.getSerializable("whichCinema");

        switch(cinemaClicked.getName()){
            case "1. Mures cinema":{
                Movie movie1=new Movie("The Gladiator","2:40","11:00","21 lei");
                Movie movie2=new Movie("Interstellar","2:20","12:00","22 lei");
                Movie movie3=new Movie("Remainings","2:10","13:00","23 lei");
                Movie movie4=new Movie("Alita","1:45","14:00","24 lei");
                Movie movie5=new Movie("Redemption","3:00","15:00","25 lei");
                Movie movie6=new Movie("It 2","1:48","16:00","20 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","19 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","17 lei");
                Movie movie9=new Movie("The conjuring","1:59","19:00","15 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);

                break;
            }
            case"2. Cluj cinema":{

                Movie movie1=new Movie("Alita","2:40","11:00","21 lei");
                Movie movie2=new Movie("Interstellar","2:20","12:00","32 lei");
                Movie movie3=new Movie("Remainings","2:10","13:00","14 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","18 lei");
                Movie movie5=new Movie("Shawshank","3:00","15:00","22 lei");
                Movie movie6=new Movie("It 2","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","22 lei");
                Movie movie9=new Movie("The conjuring","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);

                break;
            }
            case"4. Brasov cinema":{
                Movie movie1=new Movie("Interstellar","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("Remainings","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("Redemption","3:00","15:00","22 lei");
                Movie movie6=new Movie("It 2","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","22 lei");
                Movie movie9=new Movie("The conjuring","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }
            case"3. Blaj cinema":{
                Movie movie1=new Movie("The conjuring","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("Remainings","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("Redemption","3:00","15:00","22 lei");
                Movie movie6=new Movie("It 2","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","22 lei");
                Movie movie9=new Movie("Interstellar","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }
            case"5. Sibiu cinema":{
                Movie movie1=new Movie("Remainings","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("The conjuring","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("Redemption","3:00","15:00","22 lei");
                Movie movie6=new Movie("It 2","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","22 lei");
                Movie movie9=new Movie("Interstellar","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }
            case"6. Bistrita cinema":{
                Movie movie1=new Movie("It 2","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("The conjuring","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("Redemption","3:00","15:00","22 lei");
                Movie movie6=new Movie("Remainings","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","22 lei");
                Movie movie9=new Movie("Interstellar","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }
            case"7. Timisoara cinema":{
                Movie movie1=new Movie("Redemption","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("The conjuring","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("It 2","3:00","15:00","22 lei");
                Movie movie6=new Movie("Remainings","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Blade Runner","3:02","18:00","22 lei");
                Movie movie9=new Movie("Interstellar","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }
            case"8. Oradea cinema":{
                Movie movie1=new Movie("Blade Runner","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("The conjuring","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("It 2","3:00","15:00","22 lei");
                Movie movie6=new Movie("Remainings","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Redemption","3:02","18:00","22 lei");
                Movie movie9=new Movie("Interstellar","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }
            case"9. Arad cinema":{
                Movie movie1=new Movie("Black knight","2:40","11:00","22 lei");
                Movie movie2=new Movie("Alita","2:20","12:00","22 lei");
                Movie movie3=new Movie("The conjuring","2:10","13:00","22 lei");
                Movie movie4=new Movie("The Gladiator","1:45","14:00","22 lei");
                Movie movie5=new Movie("It 2","3:00","15:00","22 lei");
                Movie movie6=new Movie("Remainings","1:48","16:00","22 lei");
                Movie movie7=new Movie("Ad Astra","1:58","17:00","22 lei");
                Movie movie8=new Movie("Redemption","3:02","18:00","22 lei");
                Movie movie9=new Movie("Interstellar","1:59","19:00","22 lei");

                list.add(movie1);
                list.add(movie2);
                list.add(movie3);
                list.add(movie4);
                list.add(movie5);
                list.add(movie6);
                list.add(movie7);
                list.add(movie8);
                list.add(movie9);
                break;
            }

        }

    }

}
