package com.example.minhao.walknlearn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

/*
    Forum Adapter to convertView in list_item layout
 */
public class ForumAdapter extends ArrayAdapter<ForumVar> {

    private static final String TAG = "ForumAdapter";

    private Context mContext;
    private int mResource;

    public ForumAdapter(Context context, int resource, ArrayList<ForumVar> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String email = getItem(position).getEmail();
        String content = getItem(position).getContent();

        ForumVar forum1 = new ForumVar(name,email,content);

        //ConvertView settings
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);
        //Declare text view
        TextView textView = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.textView3);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.textView5);
        //set view information showing as google account details
        textView.setText(name);
        tvEmail.setText(email);
        tvDescription.setText(content);

        return convertView;
    }
}
