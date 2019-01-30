package com.example.aagua.hackaz2018;

import android.app.Activity;
import java.util.HashMap;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



/**
 * Created by aagua on 1/13/2018.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Animation aimShake;
    private Toolbar myToolbar;
    private Button signButton;
    private EditText firstText, lastText, phoneText, emailText, pswdText,conPswdText;
    private CheckBox isParent;


    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);

        setContentView(R.layout.activity_signup);

        myToolbar = findViewById(R.id.signin_toolbar);
        myToolbar.setTitle("Sign Up");
        setSupportActionBar(myToolbar);

        signButton=findViewById(R.id.signupButton);
        signButton.setOnClickListener(this);

        firstText = findViewById(R.id.firstName);
        lastText=findViewById(R.id.lastName);
        phoneText=findViewById(R.id.phoneText);
        emailText=findViewById(R.id.email);
        pswdText=findViewById(R.id.pswdText);
        conPswdText=findViewById(R.id.conPswdText);
        isParent=findViewById(R.id.isParent);
        aimShake= AnimationUtils.loadAnimation(this, R.anim.shake);
    }


    public void onClick(View view){
        String firstName=firstText.getText().toString().trim();
        String lastName=lastText.getText().toString().trim();
        String phoneNumber=phoneText.getText().toString().trim();
        String email=emailText.getText().toString().trim();
        String password=pswdText.getText().toString().trim();
        String conPassword=conPswdText.getText().toString().trim();
        boolean isAdmin=isParent.isChecked();

        String emailPattern="[a-zA-Z0-9._-]+@[a-z.]+\\.+[a-z]+";

        if(!conPassword.equals(password)) {
            pswdText.startAnimation(aimShake);
            conPswdText.startAnimation(aimShake);
            Toast.makeText(getApplicationContext(),"Passwords don't match!",
                            Toast.LENGTH_SHORT).show();
            return;
        }


        if (email.matches(emailPattern)) {
            User person=new User(firstName,lastName, phoneNumber, email,
                    password,isAdmin);

            MainActivity.userMap.put(email, person);
            MainActivity.loggedInUser=person;
            goToNextScreen(person);
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid email address",
                           Toast.LENGTH_SHORT).show();
        }
    }

    public void goToNextScreen(User person){
        if(person.isAdmin()){
            Intent personIntent=new Intent(this, AdminActivity.class);
            startActivity(personIntent);
        }
        else{
            Intent personIntent=new Intent(this, CalendarActivity.class);
            startActivity(personIntent);
        }
    }
}
