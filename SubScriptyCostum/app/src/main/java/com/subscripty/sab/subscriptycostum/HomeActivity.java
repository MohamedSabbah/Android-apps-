package com.subscripty.sab.subscriptycostum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    GridView listchannels;
    ArrayList<ModelChannel> channelArrayList;
    CustomArrayAdapter<ModelChannel> customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listchannels = findViewById(R.id.list);

        channelArrayList = new ArrayList<>();

        ModelChannel modelChannel = new ModelChannel();
        modelChannel.setImgChannel(R.drawable.img);
        modelChannel.setNameChannel("Metflix");

        ModelChannel modelChannel2 = new ModelChannel();
        modelChannel2.setImgChannel(R.drawable.img);
        modelChannel2.setNameChannel("GitHub");

        channelArrayList.add(modelChannel);
        channelArrayList.add(modelChannel2);

        customArrayAdapter = new CustomArrayAdapter<ModelChannel>(HomeActivity.this , channelArrayList);
        listchannels.setAdapter((ListAdapter) customArrayAdapter);


        listchannels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this , SpinnerActivity.class);
                startActivity(intent);
            }
        });


    }

}
