package com.storagesharedpreference.sab.storagesharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    EditText email, password;
    Button login ,next;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("pref_file" , MODE_PRIVATE);
        if(sharedPreferences.contains("email")){
            Intent intent = new Intent(HomeActivity.this , SecondActivity.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_home);

        email = findViewById(R.id.email_edit);
        password = findViewById(R.id.password_edit);
        login = findViewById(R.id.loginbtn);
        next = findViewById(R.id.btnnext);


        editor = sharedPreferences.edit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("email", email.getText().toString());
                editor.putString("password" , password.getText().toString());
                editor.apply();
                editor.commit();

                Intent intent = new Intent(HomeActivity.this , SecondActivity.class);
                startActivity(intent);
                finish();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this , SecondActivity.class);
                startActivity(intent);

            }
        });

    }
}
