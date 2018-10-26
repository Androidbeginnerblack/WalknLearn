package com.example.minhao.walknlearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private final String TAG = "MainActivity";

    private ConstraintLayout constraintLayout;
    private SignInButton Signin;
    private Button Signout;
    private TextView userName, userEmail;
    private ImageView userProfile;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;

    //GridLayout is used to hold cardviews
    //To implement cardview, supported dependencies must be add to Manifest.xml
    GridLayout mGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"MainActivity onCreated");
        //Initialize Constraint layout that holds Google account details
        initializeSignin();

        mGrid = (GridLayout) findViewById(R.id.myGrid);

        //Setting an event, click a cardview will start an activity
        ClickEvent(mGrid);
    }

    private void initializeSignin() {
        constraintLayout = (ConstraintLayout)findViewById(R.id.constraint2);
        Signin = (SignInButton) findViewById(R.id.signin1);
        Signout = (Button) findViewById(R.id.btn1);
        //Onclick listener
        Signin.setOnClickListener(this);
        Signout.setOnClickListener(this);
        userName = (TextView)findViewById(R.id.user_name);
        userEmail = (TextView)findViewById(R.id.user_email);
        userProfile = (ImageView) findViewById(R.id.user_photo);

        //Before Login, Information of user are not displayed
        constraintLayout.setVisibility(View.GONE);
        //Google API built-in functions, pop up windows to select signin accounts
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();
    }

    //Click on Google Sign-in Tab
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signin1:
                Log.d(TAG,"Google Signin Clicked");
                signIn();
                break;
            case R.id.btn1:
                Log.d(TAG,"Google Account Signout");
                signout();
                break;

        }
    }
    //This method must be override with onClick method as above when using Google API
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG,"Google Login Failed");
    }

    //Sign in method
    private void signIn()
    {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);
    }

    //Signout method on Button Click
    private void signout() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                changeUI(false);
            }
        });
    }
    // Handle Sign-in result
    private void handleResult(GoogleSignInResult mResult) {
        // If the account is successfully signed in
        if(mResult.isSuccess())
        {
            Log.d(TAG,"Google Signin Successful!");
            // Obtain login account information ,such as name and gmail for display
            GoogleSignInAccount mAccount = mResult.getSignInAccount();
            String name = mAccount.getDisplayName();
            String email = mAccount.getEmail();
            String img_url = mAccount.getPhotoUrl().toString();
            userName.setText(name);
            userEmail.setText(email);
            //Update the photo
            //Glide is a fast and open source image loading framework from Github
            //load url into imageView
            Glide.with(this).load(img_url).into(userProfile);
            changeUI(true);

            //Save the user information as SharedPreference
            //Allow data to be accessed in different context
            //https://developer.android.com/reference/android/content/SharedPreferences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("current_user", name);
            editor.putString("current_email", email);
            editor.commit();

        }
        else{
            Log.d(TAG,"Login failed, nothing change.");
            changeUI(false);
        }
    }

    // Update UI to show User profile
    private void changeUI(boolean isLogin) {
        if(isLogin){
            Log.d(TAG,"Show user profile.");
            constraintLayout.setVisibility(View.VISIBLE);
            Signin.setVisibility(View.GONE);
        }
        else{
            Log.d(TAG,"User Profile disable.");
            constraintLayout.setVisibility(View.GONE);
            Signin.setVisibility(View.VISIBLE);
        }
    }

    //Confirm login result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){
            Log.d(TAG,"Obtain result from Google client");
            GoogleSignInResult mResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(mResult);
        }
    }

    //CardView Design, different cardview click with different activities
    private void ClickEvent(GridLayout mGrid) {
        //Create a loop to find all the child in Grid layout
        for (int i = 0; i < mGrid.getChildCount(); i++) {
            //Cast the object to CardView
            final CardView cardView = (CardView) mGrid.getChildAt(i);
            final int indexdisplay = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG,"CardView onClicked.");
                    if(indexdisplay == 0){
                        Log.d(TAG,"Starting Achievement Activity.");
                        cardView.getContext().startActivity(new Intent(cardView.getContext(),Achievement.class));
                    }
                    //if the cardview index is 1
                    if(indexdisplay == 1){
                        Log.d(TAG,"Starting YoutubeList Activity.");
                        cardView.getContext().startActivity(new Intent(cardView.getContext(),YoutubeList.class));
                    }

                    else if(indexdisplay == 2){
                        Log.d(TAG,"Starting Quiz Activity.");
                        cardView.getContext().startActivity(new Intent(cardView.getContext(),QuizActivity.class));
                    }
                    else if(indexdisplay == 3){
                        Log.d(TAG,"Starting Forum Activity.");
                         cardView.getContext().startActivity(new Intent(cardView.getContext(),Forum.class));
                    }
                    else if(indexdisplay == 4){
                        Log.d(TAG,"Starting Bug_Report Activity.");
                         cardView.getContext().startActivity(new Intent(cardView.getContext(),Bug_Report.class));
                    }
                    else if(indexdisplay == 5){
                         Log.d(TAG,"Starting Concepts Activity.");
                         cardView.getContext().startActivity(new Intent(cardView.getContext(),Concept.class));
                    }
                    else if(indexdisplay == 6){
                           Log.d(TAG,"Prepare to exit the app");
                           //Exit the app
                           Toast.makeText(cardView.getContext(), "Exit the app.",Toast.LENGTH_SHORT).show();
                           finish();
                    }
                }
            });
        }
    }
}
