package com.subscripty.sab.subscriptycostum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner1,spinner2;
    ArrayList<String> arrCountry;
    ArrayAdapter<String> arrayAdapter;

    ArrayList<ModelChannel> modelChannels;
    CustomAdapterSpinner channelArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner1 = findViewById(R.id.spiner);
        spinner2 = findViewById(R.id.spiner2);
        arrCountry = new ArrayList<>();
        arrCountry.add("Select Country:");
        arrCountry.add("Egypt");
        arrCountry.add("Germany");
        arrCountry.add("Italy");
        arrCountry.add("Greece");
        arrCountry.add("Spain");
        arrCountry.add("UK");
        spinner1.setPrompt("Select Country");

        arrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this , android.R.layout.simple_list_item_1 , arrCountry);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setSelection(0);

        /*spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this , "The Position is : "+ i , Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        modelChannels = new ArrayList<>();
        ModelChannel modelChannel3 = new ModelChannel();
        modelChannel3.setNameChannel("Egypt");
        modelChannel3.setImgChannel(R.drawable.ic_directions_bike_black_24dp);

        ModelChannel modelChannel4 = new ModelChannel();
        modelChannel4.setNameChannel("Germany");
        modelChannel4.setImgChannel(R.drawable.ic_directions_bike_black_24dp);

        ModelChannel modelChannel5 = new ModelChannel();
        modelChannel5.setNameChannel("Italy");
        modelChannel5.setImgChannel(R.drawable.ic_directions_bike_black_24dp);

        ModelChannel modelChannel6 = new ModelChannel();
        modelChannel6.setNameChannel("USA");
        modelChannel6.setImgChannel(R.drawable.ic_directions_bike_black_24dp);



         modelChannels.add(modelChannel3);
        modelChannels.add(modelChannel4);
        modelChannels.add(modelChannel5);
        modelChannels.add(modelChannel6);

        channelArrayAdapter = new CustomAdapterSpinner(SpinnerActivity.this , modelChannels);
        spinner2.setAdapter(channelArrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this , "The Position is : "+ i , Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }




}
