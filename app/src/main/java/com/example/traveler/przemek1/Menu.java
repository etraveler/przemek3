package com.example.traveler.przemek1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Menu extends AppCompatActivity implements AsyncResponse,  View.OnClickListener {


    Button btnwyswietlhasla;
    Button btnlista;
    Button btnbus1;
    Button btnlogout;
    Button btnbus2;
    Button btnpopup;
    Button btnlistabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnwyswietlhasla = (Button) findViewById(R.id.btnwyswietlhasla);
        btnwyswietlhasla.setOnClickListener(this);
        btnlista = (Button) findViewById(R.id.btnlista);
        btnlista.setOnClickListener(this);
        btnbus1 = (Button) findViewById(R.id.btnbus1);
        btnbus1.setOnClickListener(this);
        btnlogout = (Button) findViewById(R.id.btnlogout);
        btnlogout.setOnClickListener(this);
        btnbus2 = (Button) findViewById(R.id.btnbus2);
        btnbus2.setOnClickListener(this);
        btnpopup = (Button) findViewById(R.id.btnpopup);
        btnpopup.setOnClickListener(this);
        btnlistabus = (Button) findViewById(R.id.btnlistabus);
        btnlistabus.setOnClickListener(this);
    }


    @Override
    public void processFinish(String result) {

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnwyswietlhasla:
                HashMap postData = new HashMap();
                postData.put("mobile1", "android1");

                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://traveler95.nazwa.pl/jeden/client/test.php");
                break;

            case R.id.btnlista:
                Intent in1 = new Intent(this, lista.class);
                startActivity(in1);
                break;

            case R.id.btnbus1:
                Intent in2 = new Intent(this, Tabela1.class);
                startActivity(in2);
                break;

            case R.id.btnlogout:
                Intent in3 = new Intent(this, Logowanie.class);
                startActivity(in3);
                break;
            case R.id.btnbus2:
                Intent in4 = new Intent(this, Tabela2.class);
                startActivity(in4);
                break;
            case R.id.btnpopup:
                Intent in5 = new Intent(this, Menu_nowe.class);
                startActivity(in5);
                break;
            case R.id.btnlistabus:
                Intent in6 = new Intent(this, ListaBus.class);
                startActivity(in6);
                break;

        }
    }
}