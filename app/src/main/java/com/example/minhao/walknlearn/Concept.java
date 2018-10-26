package com.example.minhao.walknlearn;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Concept extends AppCompatActivity {

    String courses [] = new String []{"INFS2608","Not Available","Not Available","Not Available"};
    private ListView courselist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);

        courselist = (ListView)findViewById(R.id.course_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
        courselist.setAdapter(adapter);
        courselist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    startActivity(new Intent(getApplicationContext(),specificConcept.class));
                }
            }
        });



    }
}
