package com.redlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class netflix extends AppCompatActivity {

    EditText edtEmail;
    Button btnLogin;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);

        edtEmail =findViewById(R.id.edt_email);
        btnLogin = findViewById(R.id.btn_login);
        imgLogo = findViewById(R.id.netflix_logo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgLogo.setImageResource(R.drawable.btn_login);
                String strEmail =edtEmail.getText().toString().trim();
                if(strEmail.equals("")){
                    Toast.makeText(netflix.this,"Please enter Email ID",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(netflix.this,"Email ID"+strEmail,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}