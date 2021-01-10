package com.jonathannalikka.contactsapplication;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;

public class ApplicationClass extends Application {

    public static final String APPLICATION_ID = "4A4D9962-DFC4-032A-FFEB-ABB14E9D2A00";
    public static final String API_KEY = "7E5C27AD-C58A-41C0-B033-59587694F56F";
    public static final String SERVER_URL = "https://api.backendless.com";

    public static BackendlessUser user;

    public static List<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}
