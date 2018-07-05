package com.subscripty.sab.subscriptly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> arrCountry;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        spinner = findViewById(R.id.spiner);
        arrCountry = new ArrayList<>();
        arrCountry.add("Select Country:");
        arrCountry.add("Egypt");
        arrCountry.add("USA");
        arrCountry.add("England");
        arrCountry.add("Germany");
        arrCountry.add("Italy");
        arrCountry.add("France");
        arrCountry.add("Spain");

spinner.setPrompt("Select Country");
        arrayAdapter = new ArrayAdapter<String>(CountryActivity.this , R.layout.row , arrCountry);
        spinner.setAdapter(arrayAdapter);

        spinner.setSelection(0);

    }
}
