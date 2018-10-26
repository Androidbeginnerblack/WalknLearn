package com.example.minhao.walknlearn;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Achievement extends AppCompatActivity {

    private TextView Good_score;
    private TextView Notbad_score;
    private TextView Bad_score;
    private TextView Not_complete;

    private ImageView good_image;
    private ImageView notbad_image;
    private ImageView bad_image;

    private TextView show_mark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int mScore = prefs.getInt("new_score",0);

        //Load text views
        Good_score = (TextView)findViewById(R.id.Good);
        Notbad_score = (TextView)findViewById(R.id.nottoobad);
        Bad_score = (TextView)findViewById(R.id.bad);
        Not_complete = (TextView)findViewById(R.id.NotComplete);

        //Initially disable them
        Good_score.setVisibility(View.GONE);
        Notbad_score.setVisibility(View.GONE);
        Bad_score.setVisibility(View.GONE);
        Not_complete.setVisibility(View.GONE);

        //Load image views
        good_image = (ImageView)findViewById(R.id.imageView2);
        notbad_image = (ImageView)findViewById(R.id.imageView3);
        bad_image = (ImageView)findViewById(R.id.imageView4);

        //Initally disable them
        good_image.setVisibility(View.GONE);
        notbad_image.setVisibility(View.GONE);
        bad_image.setVisibility(View.GONE);

        if(mScore == 0){
            Not_complete.setVisibility(View.VISIBLE);
            bad_image.setVisibility(View.VISIBLE);
        }
        else if(mScore < 5){
            Bad_score.setVisibility(View.VISIBLE);
            bad_image.setVisibility(View.VISIBLE);
        }
        else if(mScore >= 5 && mScore <= 8){
            Notbad_score.setVisibility(View.VISIBLE);
            notbad_image.setVisibility(View.VISIBLE);
        }
        else{
            Good_score.setVisibility(View.VISIBLE);
            good_image.setVisibility(View.VISIBLE);
        }

        //Show the mark
        show_mark = (TextView)findViewById(R.id.textView7);
        show_mark.setText("You got " + mScore + "/10 for this week.");
    }

}
