package com.example.aagua.hackaz2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by roxas on 1/13/2018.
 */

public class DayView extends AppCompatActivity {

    TextView todaysDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent thisIntent = getIntent();
        Bundle theIntentExtra = thisIntent.getExtras();
        int month = theIntentExtra.getInt("todaysMonth") + 1; // Month off by 1
        System.out.println("hehexd");
        int year = theIntentExtra.getInt("todaysYear");
        int day = theIntentExtra.getInt("todaysDay");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_view);
        todaysDate = (TextView) findViewById(R.id.theDate);
        todaysDate.setText("Activities for " + month + "/" + day + "/" + year);
    }

}
