package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {

            String d =(readss());

            double a = 1100.00;

                java.util.Date date= new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                int dat = cal.get(Calendar.DAY_OF_MONTH);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Runner");
                RunnerLocation Runner = new RunnerLocation(a,a,month+1,dat,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),"B13");
                myRef.child("B13").setValue(Runner);


            Log.i( "MyActivity", "MyClass.getView() — get item number "+ d );
           // Toast.makeText(getApplicationContext(),"Hello Javatpoint", Toast.LENGTH_SHORT).show();
        }
    }, 0, 1000);//put h







    }

    public String  readss() {

        GPSTracker gps = new GPSTracker(this);
        if(gps.canGetLocation()) {
            String getLatitude = String.valueOf(gps.getLatitude());
            String getLongitude = String.valueOf(gps.getLongitude());
            return getLatitude ;
        }

        return null;

    }

}
