package com.yakovleviv.rebenok;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocation(this);
    }

    // FETCH LOCATION FROM ACTIVITY AS BELOW
    public void getLocation(Context context) {
        Log.d("Main Activity", "1");

        SingleShotLocationProvider.requestSingleUpdate(context,
                new SingleShotLocationProvider.LocationCallback() {
                    @Override
                    public void onNewLocationAvailable(SingleShotLocationProvider.GPSCoordinates loc) {
                        SingleShotLocationProvider.GPSCoordinates location = loc;
                        Log.d("Main Activity", "getLocation() LAT: " + location.latitude + ", LON: " + location.longitude);
                        TextView location_txt = (TextView) findViewById(R.id.location_txt);
                        location_txt.setText("getLocation() LAT: " + location.latitude + ", LON: " + location.longitude);
                    }
                });
    }

}
