package com.example.traveler.przemek1.Nieposortowane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.traveler.przemek1.Glowne.Menu_robocze;
import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
import com.example.traveler.przemek1.R;

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

        Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnback:
                Intent in = new Intent(this, Menu_robocze.class);
                startActivity(in);
                break;


        }
    }
}









