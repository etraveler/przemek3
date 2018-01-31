package com.example.traveler.przemek1;

import android.app.Application;

import java.util.UUID;

/**
 * Created by Przemek on 28.01.2018.
 */

public class tokenGlobal extends Application {

    private String someVariable;

    public String getSomeVariable() {

        return someVariable;
    }

    public void setSomeVariable(String someVariable) {

        this.someVariable = someVariable;

    }

        public String generateString() {

            someVariable = UUID.randomUUID().toString();
            return someVariable;

        }

    }
