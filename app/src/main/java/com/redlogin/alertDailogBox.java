package com.redlogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class alertDailogBox extends AppCompatActivity {

    Button btnAlertDailog,btnCustomDailog,btnSubmit,btnCustomToast,btnToastFromCustom;
    EditText edtUserName;
    boolean btnBackPress= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dailog_box);
        btnAlertDailog=findViewById(R.id.btn_alert);
        btnCustomDailog=findViewById(R.id.btn_custom_alert);
        btnCustomToast= findViewById(R.id.btn_custom_toast);

        btnCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater=getLayoutInflater();
                View customView = layoutInflater.inflate(R.layout.raw_toast,null);
                Toast toast= new Toast(alertDailogBox.this);
                toast.setView(customView);
                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.setGravity(0,0,0);
                toast.show();
            }
        });

        btnCustomDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater=getLayoutInflater();
                View view1=layoutInflater.inflate(R.layout.raw_custom,null);
                AlertDialog.Builder builder=  new AlertDialog.Builder(alertDailogBox.this);
                edtUserName=view1.findViewById(R.id.edt_uname_custom);
                btnSubmit = view1.findViewById(R.id.btn_submit_custom);
//                btnToastFromCustom = view1.findViewById(R.id.b);
                AlertDialog alertDialog=builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setView(view1);
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String strUserName= edtUserName.getText().toString().trim();
                        if(!strUserName.equals("")){
                            View myView = layoutInflater.inflate(R.layout.raw_toast,null);
                            TextView tvData = myView.findViewById(R.id.tv_toast_custom);
                            tvData.setText(strUserName);
                            Toast toast =new Toast(alertDailogBox.this);
                            toast.setView(myView);
                            toast.setDuration(Toast.LENGTH_SHORT);
//                            toast.setGravity(0,0,0);
                            toast.show();

//                            Toast.makeText(alertDailogBox.this, "this is null" + strUserName, Toast.LENGTH_SHORT).show();
                        }
                        else{
//                            Toast.makeText(alertDailogBox.this, "this is the message: " + strUserName, Toast.LENGTH_SHORT).show();
                        }
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        // Builder does not have dismiss method so we need to call it using alertDailog method
                    }
                });
                alertDialog.show();

            }
        });

        btnAlertDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(alertDailogBox.this);
                builder.setIcon(R.drawable.netflix_logo);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete?");
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(alertDailogBox.this, "Yes is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(alertDailogBox.this, "No is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(alertDailogBox.this, "Nothing to be done", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });


    }

    @Override
    public void onBackPressed() {
    if(btnBackPress) {
            super.onBackPressed();
            return;
        }//end of if
        this.btnBackPress = true;
        Toast.makeText(alertDailogBox.this, "Press again to exit", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                btnBackPress=false;
            }
        },2000);
    }

}