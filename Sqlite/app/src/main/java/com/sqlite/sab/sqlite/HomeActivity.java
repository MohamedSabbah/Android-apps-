package com.sqlite.sab.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText editTextName , editTextBook ,editTextid;
    Button buttonEnter, buttonshow,buttondelete;

    CustomSqliteOpenHelp customSqliteOpenHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextName = findViewById(R.id.entName);
        editTextBook = findViewById(R.id.entbook);
        buttonEnter = findViewById(R.id.enter);
        editTextid = findViewById(R.id.idbook);
        buttonshow = findViewById(R.id.showbooks);
        buttondelete= findViewById(R.id.delbooksbooks);

        customSqliteOpenHelp = new CustomSqliteOpenHelp(HomeActivity.this);


        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customSqliteOpenHelp.addBook(Integer.parseInt(editTextid.getText().toString()), editTextName.getText().toString(), editTextBook.getText().toString());

            }

        });

        buttonshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this , Allbooksctivity.class);
                startActivity(intent);
            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customSqliteOpenHelp.deleteAllBooks();
            }
        });

    }
}
