package com.example.minhao.walknlearn;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class specificConcept extends AppCompatActivity {

    private final String TAG = "specificConcept";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_concept);
        Log.d(TAG,"Loaded Specific Concepts");
    }
}
