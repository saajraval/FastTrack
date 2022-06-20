package com.redlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class netflixNext extends AppCompatActivity {

    TextView tvStrEmail;
    TextView tvStrPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix_next);
        tvStrEmail=findViewById(R.id.tv_show);
        tvStrPass = findViewById(R.id.tv_showPass);
        Intent i = getIntent();
        String Pass=i.getStringExtra("KEY_PASS");
        String Email =i.getStringExtra("KEY_EMAIL");
        tvStrEmail.setText("User email is : "+Email);
        tvStrPass.setText("user name is :"+Pass);
    }
}