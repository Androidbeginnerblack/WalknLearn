package com.example.minhao.walknlearn;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

/*
    Quiz Activity is designed to test user progress performance
    Correct and wrong answer will triger Toast Message
    Result can be view in Achievement
 */

public class QuizActivity extends AppCompatActivity {

    private final String TAG = "QuizActivity";

    private Library library = new Library();
    private TextView mQuestionView;
    private Button mChoice0;
    private Button mChoice1;
    private Button mChoice2;
    private TextView endText;
    private Button quitbtn;

    private String mAnswer;
    private int mQuestionNumber = 0;
    private int score = 0;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG,"QuizActivity onCreated");
        //These view will only be shown after quiz is finish
        endText = (TextView)findViewById(R.id.textView8);
        endText.setVisibility(View.GONE);
        quitbtn = (Button)findViewById(R.id.quit_btn);
        quitbtn.setVisibility(View.GONE);
        //View of questions and choice
        mQuestionView = (TextView)findViewById(R.id.textView4);
        mChoice0 = (Button) findViewById(R.id.btn2);
        mChoice1 = (Button) findViewById(R.id.btn3);
        mChoice2 = (Button) findViewById(R.id.btn4);
        //Update question from library
        updatequestion();

        //Three button onClick section to define user selection
        mChoice0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice0.getText() == mAnswer){
                    score = score + 1;
                    updatequestion();
                    //Toast the message
                    Toast.makeText(QuizActivity.this, "Correct!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    updatequestion();
                }
            }
        });

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice1.getText() == mAnswer){
                    score = score + 1;
                    updatequestion();
                    //Toast the message
                    Toast.makeText(QuizActivity.this, "Correct!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    updatequestion();
                }
            }
        });

        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice2.getText() == mAnswer){
                    score = score + 1;
                    updatequestion();
                    //Toast the message
                    Toast.makeText(QuizActivity.this, "Correct!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    updatequestion();
                }

            }
        });

        //Clicking on quit button will finish activity (Back to MainActivity)
        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Quiz Activity Finish, return to MainActivity");
                finish();
            }
        });
    }

    // Update question and answer everytime user summit an answer
    private void updatequestion(){

        mQuestionView.setText(library.getQuestion(mQuestionNumber));
        mChoice0.setText(library.getChoice0(mQuestionNumber));
        mChoice1.setText(library.getChoice1(mQuestionNumber));
        mChoice2.setText(library.getChoice2(mQuestionNumber));
        mAnswer = library.getCorrectAnswer(mQuestionNumber);
        //Incrementing counter
        mQuestionNumber++;

        //if the question reach the end
        if(mQuestionNumber == 11){
            Log.d(TAG,"Quiz Completed");
            mChoice0.setVisibility(View.GONE);
            mQuestionView.setVisibility(View.GONE);
            mChoice1.setVisibility(View.GONE);
            mChoice2.setVisibility(View.GONE);

            endText.setVisibility(View.VISIBLE);
            quitbtn.setVisibility(View.VISIBLE);

            endText.setVisibility(View.VISIBLE);

            //Save Score for Achievement Activity
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor scoreholder = prefs.edit();
            scoreholder.putInt("new_score",score);
            scoreholder.commit();
        }


    }

}
