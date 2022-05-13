package com.example.recyclerviewwithfragments;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    //THis is the class that run even before the main_activity runs
    //And the very last thing that is being destroyed
    //Add Application name in the manifest file using the name parameter

    public static ArrayList<Person> people= new ArrayList<Person>();


    @Override
    public void onCreate() {
        super.onCreate();


        Person p1 = new Person("Hritvik Gupta", "9664033654");
        Person p2 = new Person("Harish Gupta", "9664033654");
        Person p3 = new Person("Harshit paliwal", "9664033654");


        people.add(p1);
        people.add(p2);
        people.add(p3);


    }

}
