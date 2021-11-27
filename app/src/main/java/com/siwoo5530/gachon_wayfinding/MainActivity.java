package com.siwoo5530.gachon_wayfinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Spinner spn_str;
    private Spinner spn_des;
    private String start;
    private String destination;
    private TextView text_result;
    private MyView myView;
    private PointF startP = new PointF(1000,600);
    private PointF destiP = new PointF(500,700);
    private Path route;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        spn_str = (Spinner)findViewById(R.id.spn_str);
        spn_des = (Spinner)findViewById(R.id.spn_des);
        text_result = findViewById(R.id.text_result);
        myView = (MyView) findViewById(R.id.customView);

        myView.setPointA(startP);
        myView.setPointB(destiP);

        //myView.draw();

        text_result.setText("출발지와 도착지를 선택해주세요");

        ArrayAdapter<CharSequence> buildingAdapter = ArrayAdapter.createFromResource(this, R.array.buildings, android.R.layout.simple_spinner_item);
        buildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spn_str.setAdapter(buildingAdapter);
        spn_des.setAdapter(buildingAdapter);

        spn_str.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                start = parent.getItemAtPosition(position).toString();
                //Toast.makeText(getApplicationContext(),String.valueOf(start), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn_des.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                destination = parent.getItemAtPosition(position).toString();
                //Toast.makeText(getApplicationContext(),destination, Toast.LENGTH_SHORT).show();
                DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(start,destination);
                double distance = dijkstra.getDistance();
                text_result.setText(start+" 에서 "+destination+" 까지는 "+distance+"미터 입니다.");
                ArrayList<String> stops = dijkstra.getStops();
                MyPath myPath = new MyPath(stops);
                ArrayList<PointF> pointFS = myPath.getPointFS();
                myView.setPointFS(pointFS);
                myView.draw();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spn_str;

        Intent intent = getIntent();

    }

}