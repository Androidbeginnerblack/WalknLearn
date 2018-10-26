package com.example.minhao.walknlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

public class Bug_Report extends AppCompatActivity {

    private final String TAG = "Bug_Report";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug__report);
        Log.d(TAG,"BugReport Started");
    }
}
