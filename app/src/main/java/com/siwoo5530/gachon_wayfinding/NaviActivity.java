package com.siwoo5530.gachon_wayfinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        ArrayAdapter buildingAdapter = ArrayAdapter.createFromResource(this, R.array.buildings, android.R.layout.simple_spinner_item);
        buildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spn_str.setAdapter(buildingAdapter);
        spn_des.setAdapter(buildingAdapter);
        //spn_str;

        Intent intent = getIntent();

    }
}