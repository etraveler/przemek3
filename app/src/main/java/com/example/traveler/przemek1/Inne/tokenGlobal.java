package com.example.traveler.przemek1.Inne;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.example.traveler.przemek1.Glowne.Logowanie;
import com.example.traveler.przemek1.Glowne.Menu_ladne;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.UUID;




public class tokenGlobal extends Application {

    String wynik;
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


    public void checkupr(int uprawnienia)
    {


        int intsomeVariable2 = Integer.parseInt(someVariable2);
        if (intsomeVariable2<uprawnienia)
        {
            Toast.makeText(this, "Brak uprawnień", Toast.LENGTH_SHORT).show();
            Intent check2 = new Intent(this, Menu_ladne.class);
            startActivity(check2);
        }

    }


}
