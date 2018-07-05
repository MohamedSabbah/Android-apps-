package com.first.sab.collage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView signin;
    EditText idtxt;
    EditText passTxt;
    String id;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collage);

         idtxt = findViewById(R.id.collagetxt);
         passTxt = findViewById(R.id.collagepass);
        signin = findViewById(R.id.textView);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = idtxt.getText().toString();
                pass = passTxt.getText().toString();
              //  Toast.makeText(MainActivity.this, "fixed word"+"Welcome", Toast.LENGTH_LONG).show();
               // Toast.makeText(MainActivity.this, "button clicked is"+signin.getText(), Toast.LENGTH_LONG).show();
              //  Toast.makeText(MainActivity.this, "word from string file"+getResources().getString(R.string.id), Toast.LENGTH_LONG).show();
               // Toast.makeText(MainActivity.this, "Your email is"+ id + "and your password is"+ pass, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("IdFromUser", id);
                intent.putExtra("passFromUser", pass);

                startActivity(intent);
                finish();


            }
        });

    }
}
