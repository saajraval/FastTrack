package com.redlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class netflix extends AppCompatActivity {

    EditText edtEmail;
    Button btnLogin,btnSend,btnWp;
    ImageView imgLogo;
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);

        edtEmail =findViewById(R.id.edt_email);
        btnLogin = findViewById(R.id.btn_login);
        imgLogo = findViewById(R.id.netflix_logo);
        edtPass = findViewById(R.id.edt_username);
        btnSend = findViewById(R.id.btn_send);
        btnWp = findViewById(R.id.btn_wpcode);

        btnWp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgLogo.setImageResource(R.drawable.btn_login);
                String strEmail =edtEmail.getText().toString().trim();
                String strPass = edtPass.getText().toString().trim();
                if(strEmail.equals("")){
                    Toast.makeText(netflix.this,"Please enter Email ID",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(netflix.this,"Email ID"+strEmail,Toast.LENGTH_SHORT).show();
                }
                if(strPass.equals("")){
                    Toast.makeText(netflix.this,"Please enter User Name",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(netflix.this,"User Name: "+strPass,Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(netflix.this,netflixNext.class);
                i.putExtra("KEY_EMAIL",strEmail);
                i.putExtra("KEY_PASS",strPass);
                startActivity(i);

            }
        });

    }
}