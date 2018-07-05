package com.first.sab.collage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity   {
    TextView text10 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        text10 = findViewById(R.id.textviewl);
        text10.setText(getIntent().getStringExtra("name"));
    }


}
