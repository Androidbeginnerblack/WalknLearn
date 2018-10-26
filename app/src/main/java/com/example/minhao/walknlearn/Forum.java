package com.example.minhao.walknlearn;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Forum extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
    private EditText mText;
    private static final String TAG = "Forum";
    private ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        Log.d(TAG,"Start Communicating!");

        floatingActionButton = (FloatingActionButton)findViewById(R.id.send_btn);
        mText = (EditText)findViewById(R.id.texteditor);
        mListview = (ListView)findViewById(R.id.MessageList);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_input = mText.getText().toString();

                //Create a Object for the current user
                ForumVar first = new ForumVar("John", "12-10", "Male");

                ArrayList<ForumVar> forumlist = new ArrayList<>();

                forumlist.add(first);

                ForumAdapter adapter = new ForumAdapter(getApplicationContext(), R.layout.list_item, forumlist);
                mListview.setAdapter(adapter);

            }
        });
    }
}
