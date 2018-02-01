package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Menu_ladne extends AppCompatActivity implements AsyncResponse, View.OnClickListener{


Button btnwyloguj;
Button btndodajprzedmiot;
Button btnlistabusow;
Button btndodajbusa;
Button btnedytujprzedmiot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ladne);

        btnwyloguj = (Button) findViewById(R.id.btnwyloguj);
        btnwyloguj.setOnClickListener(this);
        btndodajprzedmiot = (Button) findViewById(R.id.btndodajprzedmiot);
        btndodajprzedmiot.setOnClickListener(this);
        btnlistabusow = (Button) findViewById(R.id.btnlistabusow);
        btnlistabusow.setOnClickListener(this);
        btndodajbusa = (Button) findViewById(R.id.btndodajbusa);
        btndodajbusa.setOnClickListener(this);
        btnedytujprzedmiot = (Button) findViewById(R.id.btnedytujprzedmiot);
        btnedytujprzedmiot.setOnClickListener(this);

        Intent in8 = new Intent(this, checkToken.class);
        startActivity(in8);

    }

    @Override
    public void processFinish(String result) {
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btnwyloguj:
                HashMap postData = new HashMap();
                String token = ((tokenGlobal) this.getApplication()).getSomeVariable();
                postData.put("txtToken", token);

                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://traveler95.nazwa.pl/jeden/client/logout.php");

                Intent in4 = new Intent(this, Logowanie.class);
                startActivity(in4);
                break;
            case R.id.btndodajprzedmiot:
                Intent in5 = new Intent(this, add_Items.class);
                startActivity(in5);
                break;
            case R.id.btnlistabusow:
                Intent in6 = new Intent(this, ListaBus.class);
                startActivity(in6);
                break;
            case R.id.btnedytujprzedmiot:
                Intent in7 = new Intent(this, EdytujPrzedmiot.class);
                startActivity(in7);
                break;
            case R.id.btndodajbusa:
                Intent in8 = new Intent(this, DodajBusa.class);
                startActivity(in8);
                break;
        }
    }



}
