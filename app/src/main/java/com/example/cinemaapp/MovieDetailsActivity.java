package com.example.cinemaapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MovieDetailsActivity extends AppCompatActivity {
    private TextView fourth,fifth,sixth,seventh;
    private Button buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle;
        bundle=getIntent().getExtras();

        fourth=findViewById(R.id.fourthTextView);
        fifth=findViewById(R.id.fifthTextView);
        sixth=findViewById(R.id.sixthTextView);
        seventh=findViewById(R.id.seventhTextView);

        if(bundle!=null){
            final Cinema theCinema=(Cinema) bundle.getSerializable("cinema");
            final Movie clickedMovie=(Movie)bundle.getSerializable("movie");
            fourth.setText(clickedMovie.getName());
            fifth.setText(clickedMovie.getWhichHour());
            sixth.setText(clickedMovie.getDuration());
            seventh.setText(clickedMovie.getPrice());
            buyButton=findViewById(R.id.button);
            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MovieDetailsActivity.this,"Done!",Toast.LENGTH_LONG).show();

                    int myStringToInt= Character.getNumericValue(clickedMovie.getWhichHour().charAt(0));
                    myStringToInt*=10;
                    myStringToInt+=Character.getNumericValue(clickedMovie.getWhichHour().charAt(1));
                    int tillWhen=Character.getNumericValue(clickedMovie.getDuration().charAt(0));
                    int minutesMore=Character.getNumericValue(clickedMovie.getDuration().charAt(2));
                    int secondsMore=Character.getNumericValue(clickedMovie.getDuration().charAt(3));

                    if(minutesMore!=0||secondsMore!=0)
                        tillWhen+=1;

                    Calendar beginCal = Calendar.getInstance();
                    beginCal.set(2019, 9, 19, myStringToInt, 0);
                    long startTime = beginCal.getTimeInMillis();

                    Calendar endCal = Calendar.getInstance();
                    endCal.set(2019, 9, 19, myStringToInt+tillWhen, 0);
                    long endTime = endCal.getTimeInMillis();

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType("vnd.android.cursor.item/event");
                    intent.putExtra(CalendarContract.Events.TITLE, clickedMovie.getName());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, "Do not forget to go to the movie!");
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, theCinema.getName());
                    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginCal.getTimeInMillis());
                    intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endCal.getTimeInMillis());
                    intent.putExtra(CalendarContract.Events.STATUS, 1);
                    intent.putExtra(CalendarContract.Events.VISIBLE, 0);
                    intent.putExtra(CalendarContract.Events.HAS_ALARM, 1);
                    startActivity(intent);

                }
            });

        }
    }

}

