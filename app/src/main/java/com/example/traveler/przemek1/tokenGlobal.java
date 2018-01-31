package com.example.traveler.przemek1;

import android.app.Application;

import java.util.UUID;




public class tokenGlobal extends Application {

    private String someVariable;
    private String someVariable2;

    public String getSomeVariable() {

        return someVariable;
    }

    public String getSomeVariable2() {

        return someVariable2;
    }

    public void setSomeVariable(String someVariable) {

        this.someVariable = someVariable;

    }

    public void setSomeVariable2(String someVariable2) {

        this.someVariable2 = someVariable2;

    }

    public String generateString() {

        someVariable = UUID.randomUUID().toString();
        return someVariable;

    }

    public String generateString2() {

        someVariable2 = UUID.randomUUID().toString();
        return someVariable2;

    }
}
