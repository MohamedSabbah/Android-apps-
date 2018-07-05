package com.first.sab.collage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText view1, view2;
    private Button edit, browsre, dail ,cancel ,ok ,back;
    private Dialog dialog;
    AlertDialog.Builder alret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // initial views
        view1 = findViewById(R.id.txtact3);
        view2 = findViewById(R.id.txtact5);
        edit = findViewById(R.id.editbtn);
        browsre = findViewById(R.id.browser_btn);
        dail = findViewById(R.id.dail_btn);

        // put data inside TextVeiw by intent
        view1.setText(getIntent().getStringExtra("IdFromUser"));
        view2.setText(getIntent().getStringExtra("passFromUser"));
        edit.setOnClickListener(this);
        browsre.setOnClickListener(this);
        dail.setOnClickListener(this);
   /*     edit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View listView) {

                if (edit.getText().toString().equals("Edit")) {
                    view1.setEnabled(true);
                    view2.setEnabled(true);
                    edit.setText("Save");
                } else {
                    view1.setEnabled(false);
                    view2.setEnabled(false);
                    edit.setText("Edit");
                }


            }
        });*/
     /*  browsre.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View listView) {
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
               startActivity(intent);
           }
       });

        dail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View listView) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 12334r4"));
                startActivity(intent);


            }
    });*/


    }

  /*  public void browse(View listView) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        startActivity(intent);
    }*/

    @Override
    public void onClick(View view) {
       final Intent intent;
       switch(view.getId()){
           case R.id.browser_btn:
              /* intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
               startActivity(intent);*/
                dialog = new Dialog(ProfileActivity.this);
               dialog.setContentView(R.layout.dialog);
               dialog.setCancelable(false);

               ok = dialog.findViewById(R.id.ok);
               back = dialog.findViewById(R.id.back);
               cancel = dialog.findViewById(R.id.cancel);
               ok.setOnClickListener(this);
               cancel.setOnClickListener(this);
               back.setOnClickListener(this);

               dialog.show();
               break;
           case R.id.dail_btn:
              /*  intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 12334r4"));
               startActivity(intent);*/
              alret = new AlertDialog.Builder(ProfileActivity.this);
              alret.setTitle("Title");
              alret.setMessage("Massege");
              alret.setCancelable(false);
              alret.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent1 = new Intent(ProfileActivity.this , HomeActivity.class);
                    startActivity(intent1);
                  }
              });

               alret.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });

               alret.setNeutralButton("description", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });
               alret.show();

               break;
           case R.id.editbtn:
               if (edit.getText().toString().equals("Edit")) {
                   view1.setEnabled(true);
                   view2.setEnabled(true);
                   edit.setText("Save");
               } else {
                   view1.setEnabled(false);
                   view2.setEnabled(false);
                   edit.setText("Edit");
               }
               break;
           case R.id.ok:
               Toast.makeText(ProfileActivity.this, "ok", Toast.LENGTH_LONG).show();
               dialog.dismiss();
               break;
           case R.id.back:
               Toast.makeText(ProfileActivity.this, "back", Toast.LENGTH_LONG).show();
               dialog.dismiss();
               break;
           case R.id.cancel:
               Toast.makeText(ProfileActivity.this, "cancel", Toast.LENGTH_LONG).show();
               dialog.dismiss();
               break;

       }
    }
}


