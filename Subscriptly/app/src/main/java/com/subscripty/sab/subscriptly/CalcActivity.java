package com.subscripty.sab.subscriptly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class CalcActivity extends AppCompatActivity {
    GridView gridView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        gridView = findViewById(R.id.grid1);
        arrGrid = new ArrayList<>();
        arrGrid.add("0");
        arrGrid.add("1");
        arrGrid.add("2");
        arrGrid.add("3");
        arrGrid.add("4");
        arrGrid.add("5");
        arrGrid.add("6");
        arrGrid.add("7");
        arrGrid.add("8");
        arrGrid.add("9");
        arrayAdapter = new ArrayAdapter<String>(CalcActivity.this, R.layout.row, arrGrid);
        gridView.setAdapter(arrayAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CalcActivity.this, CountryActivity.class);
                startActivity(intent);
            }
        });

    }


}
