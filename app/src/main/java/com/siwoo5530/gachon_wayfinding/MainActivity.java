package com.siwoo5530.gachon_wayfinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText et_id;
    private Button btn_test;
    private Button btn_move;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//앱이 처음시작할때 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_id = findViewById(R.id.title);
        btn_test = findViewById(R.id.btn_test);
        btn_move = findViewById(R.id.btn_move);


        btn_test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                //et_id.setText("Helloworld");
            }
        });

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NaviActivity.class);
                startActivity(intent);
            }
        });

    }
}