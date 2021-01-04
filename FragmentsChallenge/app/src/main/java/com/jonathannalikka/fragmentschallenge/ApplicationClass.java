package com.jonathannalikka.fragmentschallenge;

import android.app.Application;

import java.util.ArrayList;

//this application class will hold a static arraylist of type car of the data

public class ApplicationClass extends Application {
        public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars =  new ArrayList<Car>();
        cars.add(new Car("volkswagen", "Polo","Chuck Norris", "2408998019"));
        cars.add(new Car("mercedes", "E200","Peter Polluck", "2023901644"));
        cars.add(new Car("nissan", "Almera","Chris James", "2408480407"));
        cars.add(new Car("mercedes", "E180","John Ranbo", "3015289596"));
        cars.add(new Car("volkswagen", "Kombi","Nelson Mandela", "2408998017"));
        cars.add(new Car("nissan", "Navara","Paul Bunting", "5711645567"));
    }
}
