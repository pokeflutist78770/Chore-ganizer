package com.example.aagua.hackaz2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aagua on 1/13/2018.
 */

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {
    private Button eventButton, messageButton;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        eventButton=findViewById(R.id.eventButton);
        eventButton.setOnClickListener(AdminActivity.this);

        eventButton=findViewById(R.id.eventButton);
        messageButton=findViewById(R.id.messageButton);
    }


    public void onClick(View view){
        switch(view.getId()){
            case R.id.messageButton:
                Intent messageIntent=new Intent(this, sendMessageActivity.class);
                startActivity(messageIntent);
                break;

            case R.id.eventButton:
                Intent eventIntent=new Intent(AdminActivity.this,
                        InputEventNameAndDescription.class);
                startActivity(eventIntent);
        }


    }

    @Override
    public void onBackPressed() {
    }
}
