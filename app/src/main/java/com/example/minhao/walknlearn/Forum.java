package com.example.minhao.walknlearn;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import 	android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Forum extends AppCompatActivity {

    private FloatingActionButton button_send;
    private chatAdapter adapter;
    private List<ForumMessage> mForum;
    private EditText text;
    private ListView mListview;
    private long mTime;
    /*get the data
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String current_name = prefs.getString("current_user","no user");
    String current_email = prefs.getString("current_email", "no email");
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        text = (EditText)findViewById(R.id.texteditor);
        mListview = (ListView) findViewById(R.id.MessageList);
        button_send = (FloatingActionButton)findViewById(R.id.send_btn);

        mForum = new ArrayList<>();

        mForum.add(new ForumMessage("Yihan", "dwadad wqe",123));
        mForum.add(new ForumMessage("Yihan", "dwadad wqe",123));
        mForum.add(new ForumMessage("Yihan", "dwadad wqe",123));
        mForum.add(new ForumMessage("Yihan", "dwadad wqe",123));

        adapter = new chatAdapter(getApplicationContext(), mForum);
        mListview.setAdapter(adapter);

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String getInput = text.getText().toString();
                //mTime = new Date().getTime();
                //add Data to the adapter

                //text.setText("");
            }
        });

    }

}
