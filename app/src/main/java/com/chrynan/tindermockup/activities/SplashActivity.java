package com.chrynan.tindermockup.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.chrynan.tindermockup.R;


public class SplashActivity extends AppCompatActivity {
    private ImageView appIcon;

    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appIcon = (ImageView) findViewById(R.id.icon);
        appIcon.setImageDrawable(getResources().getDrawable(R.drawable.temp_tinder_mockup_icon));
        //Show the icon for a few seconds before performing the logic
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*
                //Check if the user is already signed in to our app via Facebook
                if(AccessToken.getCurrentAccessToken() == null){
                    //We are not logged in so send the user to the log in Activity
                    startActivity(new Intent(SplashActivity.this, LogInActivity.class));
                }else{
                    //We are logged in so send the user to the main Activity
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }*/
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            }
        }, 2000);
    }

}
