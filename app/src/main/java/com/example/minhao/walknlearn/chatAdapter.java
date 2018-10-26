package com.example.minhao.walknlearn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class chatAdapter extends BaseAdapter {

    private Context mContext;
    private List<ForumMessage> mForumMessage;

    //Constructor


    public chatAdapter(Context mContext, List<ForumMessage> mForumMessage) {
        this.mContext = mContext;
        this.mForumMessage = mForumMessage;
    }

    @Override
    public int getCount() {
        return mForumMessage.size();
    }

    @Override
    public Object getItem(int position) {
        return mForumMessage.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext,R.layout.list_item,null);
        TextView current_user = (TextView)v.findViewById(R.id.textView2);
        TextView current_date = (TextView)v.findViewById(R.id.textView3);
        TextView current_email = (TextView)v.findViewById(R.id.textView5);

        current_user.setText(mForumMessage.get(position).getName());
        current_date.setText(mForumMessage.get(position).getDate());
        current_email.setText(mForumMessage.get(position).getEmail());

        return v;
    }
}
