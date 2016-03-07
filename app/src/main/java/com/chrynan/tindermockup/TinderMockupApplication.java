package com.chrynan.tindermockup;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class TinderMockupApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

}
