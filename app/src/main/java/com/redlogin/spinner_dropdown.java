package com.redlogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class spinner_dropdown extends AppCompatActivity {
    Spinner spinner;
    String strLang[] = {"Select Data","JAVA","CPP","C","MEAN","PYTHON","IOS","PHP",".NET"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dropdown);

        spinner=findViewById(R.id.spn);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strLang){
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tvData =(TextView) super.getDropDownView(position, convertView, parent);
                if(position == 0){
                    tvData.setTextColor(Color.GRAY);
                }
                else{

                    tvData.setTextColor(Color.MAGENTA);
                }
                return tvData;
                //this is to change the color of bg of TV
            }
        };

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strData = strLang[i];
                String strData1 = adapterView.getSelectedItem().toString();
                String strData2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(spinner_dropdown.this, "Your Coding language is : "+strData, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}