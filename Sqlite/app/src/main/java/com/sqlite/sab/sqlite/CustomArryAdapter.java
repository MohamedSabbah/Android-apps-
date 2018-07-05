package com.sqlite.sab.sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sab on 22/03/2018.
 */

public class CustomArryAdapter extends ArrayAdapter<BookModel>{
    Context context;
    TextView  textViewid, textViewName, textViewAuther;
    public CustomArryAdapter(@NonNull Context context,  @NonNull ArrayList<BookModel> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BookModel model = getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row ,parent, false);


        textViewid = convertView.findViewById(R.id.id);
        textViewName = convertView.findViewById(R.id.name);
        textViewAuther = convertView.findViewById(R.id.author);

        textViewid.setText(String.valueOf(model.getId()));
        textViewName.setText(model.getBookName());
        textViewAuther.setText(model.getBookAuthor());



        return convertView;
    }
}

