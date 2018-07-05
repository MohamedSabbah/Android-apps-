package com.subscripty.sab.subscriptycostum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sab on 21/03/2018.
 */

public class CustomAdapterSpinner  extends ArrayAdapter<ModelChannel>{

    Context context;
    public CustomAdapterSpinner(@NonNull Context context, @NonNull ArrayList<ModelChannel> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelChannel modelChannel = getItem(position) ;
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row2 ,parent , false);
        TextView country = convertView.findViewById(R.id.name_view2);
        ImageView img = convertView.findViewById(R.id.img_view2);

        country.setText(modelChannel.getNameChannel());
        img.setImageResource(modelChannel.getImgChannel());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelChannel modelChannel = getItem(position) ;
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row2 ,parent , false);
        TextView country = convertView.findViewById(R.id.name_view2);
        ImageView img = convertView.findViewById(R.id.img_view2);

        country.setText(modelChannel.getNameChannel());
        img.setImageResource(modelChannel.getImgChannel());
        return convertView;    }
}
