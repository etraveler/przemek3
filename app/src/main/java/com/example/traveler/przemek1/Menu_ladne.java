package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Menu_ladne extends AppCompatActivity implements View.OnClickListener{


Button btnwyloguj;
Button btnmenurobocze;
Button btnlistabusow;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ladne);

        btnwyloguj = (Button) findViewById(R.id.btnwyloguj);
        btnwyloguj.setOnClickListener(this);
        btnmenurobocze = (Button) findViewById(R.id.btnmenurobocze);
        btnmenurobocze.setOnClickListener(this);
        btnlistabusow = (Button) findViewById(R.id.btnlistabusow);
        btnlistabusow.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnwyloguj:
                Intent in4 = new Intent(this, Logowanie.class);
                startActivity(in4);
                break;
            case R.id.btnmenurobocze:
                Intent in5 = new Intent(this, Menu.class);
                startActivity(in5);
                break;
            case R.id.btnlistabusow:
                Intent in6 = new Intent(this, ListaBus.class);
                startActivity(in6);
                break;
        }
    }



}
