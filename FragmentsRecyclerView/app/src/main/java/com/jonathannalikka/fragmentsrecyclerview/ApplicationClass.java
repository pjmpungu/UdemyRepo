package com.jonathannalikka.fragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Chuck Norris", "2408998019"));
        people.add(new Person("John Rambo", "3015289596"));
        people.add(new Person("Nelson Mandela", "2408480407"));
    }


}
