package com.storagesharedpreference.sab.storagesharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView dataemail, datapass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button buttonEdit , deletebtn;
    EditText editTextEmail,editTextpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dataemail = findViewById(R.id.dataemail);
        datapass = findViewById(R.id.datapass);
        buttonEdit = findViewById(R.id.linebtn1);
        editTextEmail = findViewById(R.id.edit_email);
        editTextpass = findViewById(R.id.edit_pass);
        deletebtn = findViewById(R.id.linebtndel);
        editTextEmail.setEnabled(false);
        editTextpass.setEnabled(false);



        sharedPreferences = getSharedPreferences("pref_file" , MODE_PRIVATE);

        editTextEmail.setText(sharedPreferences.getString("email" ,"no email"));
        editTextpass.setText(sharedPreferences.getString("password" ,"no password"));


        editor = sharedPreferences.edit();

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            boolean b = false;
            @Override
            public void onClick(View view) {
                if(buttonEdit.getText().toString().equals("Edit")){
                    editTextEmail.setEnabled(true);
                    editTextpass.setEnabled(true);
                    buttonEdit.setText("Save");
                    b = true;
                }else {
                    editTextEmail.setEnabled(false);
                    editTextpass.setEnabled(false);
                    editor.putString("email", editTextEmail.getText().toString());
                    editor.putString("password" , editTextpass.getText().toString());
                    editor.apply();
                    editor.commit();
                    b = false;
                    buttonEdit.setText("Edit");

                }


            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                editor.apply();


                editTextpass.setText("");
                editTextEmail.setText("");


            }
        });



    }
}
