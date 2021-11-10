package com.siwoo5530.gachon_wayfinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class NaviActivity extends AppCompatActivity {


    ImageView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        test = (ImageView)findViewById(R.id.test);
        Intent intent = getIntent();


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"HelloWorld",Toast.LENGTH_SHORT).show();
            }
        });
    }
}