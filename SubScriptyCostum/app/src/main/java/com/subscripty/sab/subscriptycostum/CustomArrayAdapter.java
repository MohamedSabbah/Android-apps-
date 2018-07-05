package com.subscripty.sab.subscriptycostum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sab on 20/03/2018.
 */

public class CustomArrayAdapter<M> extends ArrayAdapter<ModelChannel> {

    Context context;
    public CustomArrayAdapter(@NonNull Context context, @NonNull ArrayList<ModelChannel> objects) {
        super(context, 0 , objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelChannel modelChannel = getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row ,parent , false);
        TextView name = convertView.findViewById(R.id.name_view);
        ImageView img =  convertView.findViewById(R.id.img_view);

        name.setText(modelChannel.getNameChannel());
        img.setImageResource(modelChannel.getImgChannel());
        return convertView;
    }
}
