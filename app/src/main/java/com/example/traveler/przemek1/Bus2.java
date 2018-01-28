package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Bus2 extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus2);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);


        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener((View.OnClickListener) this);

        //Create the Autobus objects

        ArrayList<Autobus> peopleList = new ArrayList<>();
        int number=1;

        while (number<10)
        {


            String numerstring = number + "";
            Autobus osoba = new Autobus("John", numerstring,"Male");
            peopleList.add(osoba);
            number++;
        }




      /*
        Autobus john = new Autobus("John","12-20-1998","Male");
        Autobus steve = new Autobus("Steve","08-03-1987","Male");
        Autobus stacy = new Autobus("Stacy","11-15-2000","Female");
        Autobus ashley = new Autobus("Ashley","07-02-1999","Female");
        Autobus matt = new Autobus("Matt","03-29-2001","Male");
        Autobus matt2 = new Autobus("Matt2","03-29-2001","Male");
        Autobus matt3 = new Autobus("Matt3","03-29-2001","Male");
        Autobus matt4 = new Autobus("Matt4","03-29-2001","Male");
        Autobus matt5 = new Autobus("Matt5","03-29-2001","Male");
        Autobus matt6 = new Autobus("Matt6","03-29-2001","Male");
        Autobus matt7 = new Autobus("Matt7","03-29-2001","Male");
        Autobus matt8 = new Autobus("Matt8","03-29-2001","Male");
        Autobus matt9 = new Autobus("Matt9","03-29-2001","Male");
        Autobus matt10 = new Autobus("Matt10","03-29-2001","Male");
        Autobus matt11 = new Autobus("Matt11","03-29-2001","Male");

        //Add the Autobus objects to an ArrayList
        ArrayList<Autobus> peopleList = new ArrayList<>();


        peopleList.add(john);
        peopleList.add(ashley);
        peopleList.add(matt);
        peopleList.add(matt2);
        peopleList.add(matt3);
        peopleList.add(matt4);
        peopleList.add(matt5);
        peopleList.add(matt6);
        peopleList.add(matt7);
        peopleList.add(matt8);
        peopleList.add(matt9);
        peopleList.add(matt10);
        peopleList.add(matt11);
*/
        BusListAdapter adapter = new BusListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnback:
                Intent in = new Intent(this, Ekran1.class);
                startActivity(in);
                break;


        }
    }
}









