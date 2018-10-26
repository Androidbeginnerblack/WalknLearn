package com.example.minhao.walknlearn;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final String user_name = prefs.getString("current_user", "No login");
        final String user_email = prefs.getString("current_email", "No email");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_input = mText.getText().toString();
                //Create a Object for the current user
                ArrayList<ForumVar> forumlist = new ArrayList<>();
                forumlist.add(new ForumVar(user_name, user_email, current_input));

                ForumAdapter adapter = new ForumAdapter(getApplicationContext(), R.layout.list_item, forumlist);
                mListview.setAdapter(adapter);

                mText.setText("");

            }
        });
    }
}
