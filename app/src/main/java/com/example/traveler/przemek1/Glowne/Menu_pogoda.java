package com.example.traveler.przemek1.Glowne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.traveler.przemek1.Nieposortowane.Employees;
import com.example.traveler.przemek1.Inne.checkToken;
import com.example.traveler.przemek1.Nieposortowane.Temperatura;
import com.example.traveler.przemek1.R;
import com.example.traveler.przemek1.Inne.tokenGlobal;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Menu_pogoda extends AppCompatActivity implements AsyncResponse, View.OnClickListener{



    Button btntemperature;
    Button btnwyloguj;
    Button btnzanieczyszczenie;
    Button btndeszcz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pogoda);

        btndeszcz = (Button) findViewById(R.id.btndeszcz);
        btndeszcz.setOnClickListener(this);
        btnzanieczyszczenie = (Button) findViewById(R.id.btnzanieczyszczenie );
        btnzanieczyszczenie .setOnClickListener(this);
        btntemperature = (Button) findViewById(R.id.btntemperature);
        btntemperature.setOnClickListener(this);
        btnwyloguj = (Button) findViewById(R.id.btnwyloguj);
        btnwyloguj.setOnClickListener(this);

        Intent check = new Intent(this, checkToken.class);
        startActivity(check);


        String uprawnienia = ((tokenGlobal) this.getApplication()).getSomeVariable2();
        Toast.makeText(this, "Poziom uprawnień: "+uprawnienia, Toast.LENGTH_SHORT).show();
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

                Intent in1 = new Intent(this, Logowanie.class);
                startActivity(in1);
                break; 

            case R.id.btntemperature:
                Intent in2 = new Intent(this, Temperatura.class);
                startActivity(in2);
                break;
            case R.id.btndeszcz:
                Intent in3 = new Intent(this, Temperatura.class);
                startActivity(in3);
                break;
            case R.id.btnzanieczyszczenie:
                Intent in4 = new Intent(this, Temperatura.class);
                startActivity(in4);
                break;


        }
    }




}