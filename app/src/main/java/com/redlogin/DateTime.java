package com.redlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTime extends AppCompatActivity {

    TextView tvDate,tvTime;
    Button btnDate,btnTime;
    int year ,month,day,hours,mins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        tvDate = findViewById(R.id.tv_date);
        btnDate = findViewById(R.id.btn_Date);
        tvTime = findViewById(R.id.tv_time);
        btnTime= findViewById(R.id.btn_Time);

        Calendar calendar =Calendar.getInstance();
        year= calendar.get(calendar.YEAR);
        month= calendar.get(calendar.MONTH);
        day = calendar.get(calendar.DAY_OF_MONTH);

        hours = calendar.get(Calendar.HOUR_OF_DAY);
        mins=calendar.get(Calendar.MINUTE);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int mins) {
                        tvTime.setText(hours+":"+mins);
                    }
                },hours,mins,false);
                timePickerDialog.show();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTime.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        tvDate.setText(day+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }
}