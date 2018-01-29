package com.example.traveler.przemek1;

import android.app.Application;

/**
 * Created by Przemek on 28.01.2018.
 */

class MyApplication extends Application{

    private String someVariable;


    public String getSomeVariable() {

        return someVariable;
    }

    public void setSomeVariable(String someVariable) {

        this.someVariable = someVariable;

    }




}