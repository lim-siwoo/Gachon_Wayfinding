package com.siwoo5530.gachon_wayfinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class NaviActivity extends AppCompatActivity {

    private Spinner spn_str;
    private Spinner spn_des;
    private String[] buildings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        spn_str = (Spinner)findViewById(R.id.spn_str);
        spn_des = (Spinner)findViewById(R.id.spn_des);

        ArrayAdapter<CharSequence> buildingAdapter = ArrayAdapter.createFromResource(this, R.array.buildings, android.R.layout.simple_spinner_item);
        buildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spn_str.setAdapter(buildingAdapter);
        spn_des.setAdapter(buildingAdapter);

        spn_str.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(parent.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn_des.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(parent.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spn_str;

        Intent intent = getIntent();

    }
}