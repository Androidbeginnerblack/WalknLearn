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
    Youtube listview before playing specific videos
 */

public class YoutubeList extends AppCompatActivity {

    String courses [] = new String []{"INFS2608","Not Available","Not Available","Not Available"};
    private final String TAG = "YoutubeList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_list);

        ListView listView = (ListView)findViewById(R.id.youtubelist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Log.d(TAG,"Play INFS2608 Video.");
                    startActivity(new Intent(getApplicationContext(),YoutubeAPI.class));
                }
            }
        });
    }
}
