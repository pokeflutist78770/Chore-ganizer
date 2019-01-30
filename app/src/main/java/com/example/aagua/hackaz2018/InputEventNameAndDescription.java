package com.example.aagua.hackaz2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by roxas on 1/13/2018.
 */

public class InputEventNameAndDescription extends Activity implements View.OnClickListener {

    String eventName;
    String eventDescription;
    EditText nameBox;
    EditText descriptionBox;
    Button toTimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.input_name_and_description);
        nameBox = findViewById(R.id.eventName);
        descriptionBox = findViewById(R.id.eventDescription);
        toTimeButton = findViewById(R.id.timeButton);
        toTimeButton.setOnClickListener(InputEventNameAndDescription.this);
    }

    public void     onClick(View view) {
        eventName = nameBox.getText().toString();
        eventDescription = descriptionBox.getText().toString();
        Intent toInputTime = new Intent(InputEventNameAndDescription.this, TimePicker.class);
        toInputTime.putExtra("theEventsName", eventName);
        toInputTime.putExtra("theEventsDescription", eventDescription);
        startActivity(toInputTime);
    }
}
