package com.sqlite.sab.sqlite;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Allbooksctivity extends AppCompatActivity {
    ListView listView;
    Button buttonYes , buttonNo ;
    EditText textId,textName,textBook;
    ArrayList<BookModel> allBModels;
    CustomSqliteOpenHelp customSqliteOpenHelp;
    CustomArryAdapter allBModelCustomArryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allbooksctivity);


        listView = findViewById(R.id.listview);

        customSqliteOpenHelp = new CustomSqliteOpenHelp(Allbooksctivity.this);
        allBModels = customSqliteOpenHelp.retrieveAllBooks();

        allBModelCustomArryAdapter = new CustomArryAdapter(Allbooksctivity.this , allBModels);
        listView.setAdapter(allBModelCustomArryAdapter);

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Allbooksctivity.this , "Position "+i , Toast.LENGTH_LONG).show();
                customSqliteOpenHelp.deleteOneBook(allBModels.get(i).getId());

                allBModels.remove(i);
                allBModelCustomArryAdapter.notifyDataSetChanged();


            }
        });*/
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            Dialog dialog ;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                dialog = new Dialog(Allbooksctivity.this);
                dialog.setContentView(R.layout.layout_dailog);
                textId = dialog.findViewById(R.id.dailogid);
                textName =dialog.findViewById(R.id.dailogAuthor);
                textBook = dialog.findViewById(R.id.dailogBook);
                buttonYes = dialog.findViewById(R.id.yes);
                buttonNo = dialog.findViewById(R.id.no);
                dialog.setCancelable(false);

                textId.setText(allBModels.get(i).getId()+ " ");
                textName.setText(allBModels.get(i).getBookAuthor());
                textBook.setText(allBModels.get(i).getBookName());
                buttonYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                       // allBModels.get(i).setId(Integer.parseInt(textId.getText().toString()));
                        allBModels.get(i).setBookName(textBook.getText().toString());
                        allBModels.get(i).setBookAuthor(textName.getText().toString());
                        allBModelCustomArryAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                        customSqliteOpenHelp.updateBook(allBModels.get(i).getId() ,textBook.getText().toString() , textName.getText().toString() );

                    }
                });
                buttonNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });

    }
}
