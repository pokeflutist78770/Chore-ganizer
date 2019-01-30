package com.example.aagua.hackaz2018;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_layout);
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarDayEvent());
    }

    private class CalendarDayEvent implements CalendarView.OnDateChangeListener {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                /*
                System.out.println(month + " " + dayOfMonth + " " + year);
                Toast.makeText(getBaseContext(), month + " " + dayOfMonth + " " +
                        year, Toast.LENGTH_LONG).show();
                */
            Intent theDayScreen = new Intent(CalendarActivity.this, DayView.class);
            theDayScreen.putExtra("todaysYear",year);
            theDayScreen.putExtra("todaysDay", dayOfMonth);
            theDayScreen.putExtra("todaysMonth", month);
            startActivity(theDayScreen);
        }
    }

}
