package com.example.minhao.walknlearn;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Achievement extends AppCompatActivity {

    private TextView Good_score;
    private TextView Notbad_score;
    private TextView Bad_score;
    private TextView Not_complete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int mScore = prefs.getInt("new_score",0);

        Good_score = (TextView)findViewById(R.id.Good);
        Notbad_score = (TextView)findViewById(R.id.nottoobad);
        Bad_score = (TextView)findViewById(R.id.bad);
        Not_complete = (TextView)findViewById(R.id.NotComplete);


        //Initially disable them
        Good_score.setVisibility(View.GONE);
        Notbad_score.setVisibility(View.GONE);
        Bad_score.setVisibility(View.GONE);
        Not_complete.setVisibility(View.GONE);

        if(mScore == 0){
            Not_complete.setVisibility(View.VISIBLE);
        }
        else if(mScore > 1){
            Bad_score.setVisibility(View.VISIBLE);
        }
    }

}
