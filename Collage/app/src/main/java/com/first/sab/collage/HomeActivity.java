package com.first.sab.collage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    ListView listView;
    ArrayList <String>arrayList ;
    ArrayAdapter<String> arrayAdapter;
    Button button ;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        button = findViewById(R.id.add);
        text = findViewById(R.id.enter_version_android);
        listView = findViewById(R.id.list1);

        arrayList = new ArrayList<String>();
        arrayList.add("terms and Conditions");
        arrayList.add("Privacy Police" );
        arrayList.add("Lolipop");
        arrayList.add ("Kitkat");
        arrayList.add("Ice Cream");

        arrayAdapter = new ArrayAdapter<String>(HomeActivity.this, R.layout.row_layout, arrayList);
        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HomeActivity.this, "position is:" + i ,Toast.LENGTH_LONG).show();
            }
        });

       button.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {
               Toast.makeText(HomeActivity.this, "welcome:"  ,Toast.LENGTH_LONG).show();

               return false;
           }
       });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this , DetailsActivity.class);
                intent.putExtra("name" , arrayList.get(i));
                startActivity(intent);
                return false;
            }
        });

        button.setOnClickListener(this);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater = new MenuInflater(HomeActivity.this);
        menuInflater.inflate(R.menu.first_menu, menu);


        //JAVA CODE ONLY

       /* menu.add(0 , Menu.FIRST, 0, "option1" );
        menu.add(0 , 2, 0, "option2" );
        menu.add(0 , 3, 0, "option3" );*/


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       /* switch (item.getItemId()){

            case 1:
                Toast.makeText(HomeActivity.this ,item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(HomeActivity.this ,item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(HomeActivity.this ,"Welccome", Toast.LENGTH_LONG).show();
                break;
        }*/

       switch (item.getItemId()){
           case R.id.option2:
               Toast.makeText(HomeActivity.this ,"Welccome", Toast.LENGTH_LONG).show();
               break;

           case R.id.option3:
               Toast.makeText(HomeActivity.this ,"Welccome", Toast.LENGTH_LONG).show();
               break;

           case R.id.option4:
               Toast.makeText(HomeActivity.this ,"Welccome", Toast.LENGTH_LONG).show();
               break;

           case R.id.option1:
               Toast.makeText(HomeActivity.this ,"Welccome", Toast.LENGTH_LONG).show();
               break;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
                arrayList.add(text.getText().toString());
                arrayAdapter.notifyDataSetChanged();
              //  arrayAdapter = new ArrayAdapter<String>(HomeActivity.this, R.layout.row_layout, arrayList);
               // listView.setAdapter(arrayAdapter);
                    text.setText("");
                break;

        }


    }


}
