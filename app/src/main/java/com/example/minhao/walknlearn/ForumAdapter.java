package com.example.minhao.walknlearn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        String birthday = getItem(position).getBirthday();
        String sex = getItem(position).getSex();

        ForumVar forum1 = new ForumVar(name,birthday,sex);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        //Declare text view
        TextView textView = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.textView3);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.textView5);

        textView.setText(name);
        tvEmail.setText(birthday);
        tvDescription.setText(sex);

        return convertView;
    }
}
