package com.example.aagua.hackaz2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;



import java.util.HashMap;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button loginButton;
    private Button signUpButton;
    public static User loggedInUser=null;
    public static HashMap<String, User> userMap=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //hides the action bar for us
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //sets up the buttons
        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        signUpButton = findViewById(R.id.signup);
        signUpButton.setOnClickListener(MainActivity.this);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.login:
                switchToLogin();
                break;
            case R.id.signup:
                switchToSignUp();
                break;
            default:
                break;
        }

    }

    public void switchToLogin(){
        Intent loginIntent=new Intent(MainActivity.this, Login.class);
        startActivity(loginIntent);
    }

    public void switchToSignUp(){
        Intent signupIntent=new Intent(this, SignUpActivity.class);
        startActivity(signupIntent);
    }
}
