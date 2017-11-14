package com.example.arnav47.attendance511;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2;
    Button button;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, ScanNFC.class);
//        startActivity(intent);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button)findViewById(R.id.button);
        GPSTracker tracker = new GPSTracker(this);
        tracker.getLocation();
//        float[] result = new float[1];
//        //long and lat of college and a radius of 100 metres
//        Location.distanceBetween (12.941635, 77.565726,tracker.longitude,tracker.latitude,result);

        if( 3>2 )
        {
            Toast.makeText(MainActivity.this, "Location Verified! ", Toast.LENGTH_SHORT).show();
            textView2.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BLEreceive.class));
            }
        });






    }




}

