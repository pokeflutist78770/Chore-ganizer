package com.example.aagua.hackaz2018;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;


/**
 * Created by aagua on 1/13/2018.
 */

public class Login extends AppCompatActivity implements View.OnClickListener  {
    private Button nextPageButton;
    private Toolbar myToolbar;
    private EditText emailText;
    private EditText passText;

    private DatabaseReference DBReference;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myToolbar = findViewById(R.id.login_toolbar);
        myToolbar.setTitle("Log In");
        setSupportActionBar(myToolbar);

        nextPageButton=findViewById(R.id.next);
        nextPageButton.setOnClickListener(this);

        emailText=findViewById(R.id.emailText);
        passText=findViewById(R.id.passwordText);
    }




    public void onClick(View view){
        String email=emailText.getText().toString().trim();
        String password=passText.getText().toString().trim();
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern) && MainActivity.userMap.containsKey(email)) {
            User person=MainActivity.userMap.get(email);

            if(person.getPasswd().equals(password)){
                MainActivity.loggedInUser=person;
                goToNextScreen();
            }
            else{
                Toast.makeText(getApplicationContext(), "Wrong Password. Please try again",
                                 Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }

    }



    public void goToNextScreen(){
        Intent nextPageIntent;

        if(MainActivity.loggedInUser.isAdmin()){
            nextPageIntent=new Intent(this, AdminActivity.class);
            startActivity(nextPageIntent);
        }
        else{
            nextPageIntent=new Intent(this, CalendarActivity.class);
            startActivity(nextPageIntent);
        }
    }
}
