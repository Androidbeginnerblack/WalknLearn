package com.example.minhao.walknlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

/*
    Concept activity contains listview that allow user to open specific video for each course.
 */

public class Concept extends AppCompatActivity {

    private final String TAG = "Concept";

    String courses [] = new String []{"INFS2608","Not Available","Not Available","Not Available"};
    private ListView courselist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);
        Log.d(TAG,"Concept onCreated.");

        courselist = (ListView)findViewById(R.id.course_list);
        //simple_list_item is default used to print one line string in adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
        //set Adapter for listview
        courselist.setAdapter(adapter);
        //Listitem onClick listener
        courselist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Log.d(TAG,"First item of List View Clicked.");
                    startActivity(new Intent(getApplicationContext(),specificConcept.class));
                }
            }
        });



    }
}
