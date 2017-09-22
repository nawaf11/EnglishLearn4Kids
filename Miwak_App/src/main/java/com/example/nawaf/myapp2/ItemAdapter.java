package com.example.nawaf.myapp2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<Item>  {
    private  int backColor;

    public ItemAdapter(Activity activity , ArrayList<Item> objects , int bcColor) {
        super(activity, 0 , objects);
        backColor=bcColor;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItem =  convertView;
        if(listItem ==null){
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
        }
        TextView t1 =  (TextView)listItem.findViewById(R.id.txt_s1);
        TextView t2 =  (TextView)listItem.findViewById(R.id.txt_s2);
        ImageView img = (ImageView) listItem.findViewById(R.id.imgView);

        t1.setText(getItem(position).getS1());
        t2.setText(getItem(position).getS2());
        img.setImageResource(getItem(position).getResImg());

        LinearLayout linearLay = (LinearLayout) listItem.findViewById(R.id.txtContainer);
        int color = ContextCompat.getColor(getContext() , backColor);
        linearLay.setBackgroundColor(color);

        LinearLayout linearLay2 = (LinearLayout) listItem.findViewById(R.id.linear3);
        int color2 = ContextCompat.getColor(getContext() , backColor);
        linearLay2.setBackgroundColor(color2);


        return listItem;
       // return super.getView(position, convertView, parent);


    }
}
