package com.example.traveler.przemek1.Glowne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.traveler.przemek1.Bus.Busy;
import com.example.traveler.przemek1.Chat.Chat;
import com.example.traveler.przemek1.Dodatki.Dodatki;
import com.example.traveler.przemek1.Kalendarz.Kalendarz;
import com.example.traveler.przemek1.Nieposortowane.Employees;
import com.example.traveler.przemek1.Inne.checkToken;
import com.example.traveler.przemek1.R;
import com.example.traveler.przemek1.Inne.tokenGlobal;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Menu_ladne extends AppCompatActivity implements AsyncResponse, View.OnClickListener{



Button btnbusy;
Button btndodatki;
Button btnemployees;
Button btnwyloguj;
Button btnkalendarz;
Button btnchat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ladne);


        btndodatki = (Button) findViewById(R.id.btndodatki);
        btndodatki.setOnClickListener(this);
        btnbusy = (Button) findViewById(R.id.btnbusy);
        btnbusy.setOnClickListener(this);
        btnemployees = (Button) findViewById(R.id.btnemployees);
        btnemployees.setOnClickListener(this);
        btnwyloguj = (Button) findViewById(R.id.btnwyloguj);
        btnwyloguj.setOnClickListener(this);
        btnkalendarz = (Button) findViewById(R.id.btnkalendarz);
        btnkalendarz.setOnClickListener(this);
        btnchat = (Button) findViewById(R.id.btnchat);
        btnchat.setOnClickListener(this);

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
            case R.id.btnbusy:
                Intent in2 = new Intent(this, Busy.class);
                startActivity(in2);
                break;
            case R.id.btndodatki:
                Intent in3 = new Intent(this, Dodatki.class);
                startActivity(in3);
                break;
            case R.id.btnemployees:
                Intent in4 = new Intent(this, Employees.class);
                startActivity(in4);
                 break;
            case R.id.btnkalendarz:
                Intent in5 = new Intent(this, Kalendarz.class);
                startActivity(in5);
                break;
            case R.id.btnchat:
                Intent in6 = new Intent(this, Chat.class);
                startActivity(in6);
                break;
    }
    }




}
