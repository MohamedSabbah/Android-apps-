package com.sqlite.sab.movies.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sqlite.sab.movies.R;
import com.sqlite.sab.movies.activities.HomeActivity;
import com.sqlite.sab.movies.models.ModelMovie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sab on 24/03/2018.
 */

public class CustomArrayAdapter extends ArrayAdapter<ModelMovie> {
    Context context;
    public CustomArrayAdapter(@NonNull Context context, @NonNull ArrayList<ModelMovie> objects) {
        super(context, 0, objects);
       this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelMovie movie = getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row ,parent, false);
        TextView textView = convertView.findViewById(R.id.txt_movie);
        ImageView imageView = convertView.findViewById(R.id.img_movie);

        textView.setText(movie.getTxtfilm());
    //    imageView.setImageResource(movie.getImgfilm());
        Picasso.with(context).load(movie.getImgfilm()).into(imageView);


        return convertView;
    }


}
