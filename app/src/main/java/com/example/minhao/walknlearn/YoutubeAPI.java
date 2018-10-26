package com.example.minhao.walknlearn;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

/*
    Youtube functions extends from Youtbe API library
 */

public class YoutubeAPI extends YouTubeBaseActivity {

    // Youtube Video Fragement
    YouTubePlayerView youTubePlayerView;
    Button btn1;
    // Youtube initializelistener method must be used
    YouTubePlayer.OnInitializedListener onInitializedListener;
    // Create Log for program sequence
    private final String TAG = "YoutubeAPI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_api);

        Log.d(TAG,"Youtube Video Section");
        btn1 = (Button) findViewById(R.id.bn);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            // If the initialization succeed, load the String to load video
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "Youtube initialization Complete");
                youTubePlayer.loadVideo("Vy8f80XUt6I");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "Youtube initialization Failed");
            }
        };

        //Button to display video
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize(YoutubeConfigure.getAPI_Key(), onInitializedListener);
            }
        });
    }
}
