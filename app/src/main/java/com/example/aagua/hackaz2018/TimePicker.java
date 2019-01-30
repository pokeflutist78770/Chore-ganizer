package com.example.aagua.hackaz2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.HashMap;

/**
 * Created by roxas on 1/13/2018.
 */

public class TimePicker extends Activity implements View.OnClickListener {

    Button nextButton;
    private HashMap<String, EventLinkedList> events = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.time_picker);
        nextButton = findViewById(R.id.done);
        nextButton.setOnClickListener(TimePicker.this);
    }

    public void onClick (View view) {
        Intent backToStart = new Intent(TimePicker.this, AdminActivity.class);
        startActivity(backToStart);
    }
}
