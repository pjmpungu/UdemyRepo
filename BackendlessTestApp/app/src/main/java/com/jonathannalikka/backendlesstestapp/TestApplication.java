package com.jonathannalikka.backendlesstestapp;

import android.app.Application;

import com.backendless.Backendless;

public class TestApplication extends Application {

    public static final String APPLICATION_ID = "C8BABCE7-0C34-00A2-FFE6-EB0EF9171D00";
    public static final String API_KEY = "2819AEEC-4BA3-4BDE-A5F0-F2D95C723C4C";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL );
        Backendless.initApp(getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}
