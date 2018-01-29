package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Tabela2 extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela2);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);


        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener((View.OnClickListener) this);

        //Create the Wiersz12 objects

        ArrayList<Wiersz12> peopleList = new ArrayList<>();
        int number=1;

        while (number<10)
        {


            String numerstring = number + "";
            Wiersz12 osoba = new Wiersz12("John", numerstring,"Male");
            peopleList.add(osoba);
            number++;
        }




      /*
        Wiersz12 john = new Wiersz12("John","12-20-1998","Male");
        Wiersz12 steve = new Wiersz12("Steve","08-03-1987","Male");
        Wiersz12 stacy = new Wiersz12("Stacy","11-15-2000","Female");
        Wiersz12 ashley = new Wiersz12("Ashley","07-02-1999","Female");
        Wiersz12 matt = new Wiersz12("Matt","03-29-2001","Male");
        Wiersz12 matt2 = new Wiersz12("Matt2","03-29-2001","Male");
        Wiersz12 matt3 = new Wiersz12("Matt3","03-29-2001","Male");
        Wiersz12 matt4 = new Wiersz12("Matt4","03-29-2001","Male");
        Wiersz12 matt5 = new Wiersz12("Matt5","03-29-2001","Male");
        Wiersz12 matt6 = new Wiersz12("Matt6","03-29-2001","Male");
        Wiersz12 matt7 = new Wiersz12("Matt7","03-29-2001","Male");
        Wiersz12 matt8 = new Wiersz12("Matt8","03-29-2001","Male");
        Wiersz12 matt9 = new Wiersz12("Matt9","03-29-2001","Male");
        Wiersz12 matt10 = new Wiersz12("Matt10","03-29-2001","Male");
        Wiersz12 matt11 = new Wiersz12("Matt11","03-29-2001","Male");

        //Add the Wiersz12 objects to an ArrayList
        ArrayList<Wiersz12> peopleList = new ArrayList<>();


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
        Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnback:
                Intent in = new Intent(this, Menu.class);
                startActivity(in);
                break;


        }
    }
}









