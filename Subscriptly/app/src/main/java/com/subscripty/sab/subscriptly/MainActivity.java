package com.subscripty.sab.subscriptly;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> allChannels;
    ArrayAdapter<String> arrayAdapter;



    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etxt);
        button = findViewById(R.id.btn);
        listView = findViewById(R.id.list);
        allChannels = new ArrayList<>();
        allChannels.add("Netflix");
        allChannels.add("Spotify");
        allChannels.add("GitHubs");
        allChannels.add("Dribble");






        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row, allChannels);


        listView.setAdapter(arrayAdapter);


       /* if (i %2==0)
            listView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else
            listView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "position of item is: " + i, Toast.LENGTH_LONG).show();
                if(allChannels.get(i).equals("GitHubs")){
                    Intent intent = new Intent(MainActivity.this , CalcActivity.class);
                    startActivity(intent);
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("name", allChannels.get(i));
                startActivity(intent);

                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();

                allChannels.add(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
