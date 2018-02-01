package com.example.traveler.przemek1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class add_Items extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    Button dodaj;
    TextView kod, nazwa, rodzaj, cena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__items);

        nazwa = (EditText) findViewById(R.id.nazwa);
        kod = (EditText) findViewById(R.id.kod);
        rodzaj  = (EditText) findViewById(R.id.rodzaj);
        cena  = (EditText) findViewById(R.id.cena);

        dodaj = (Button) findViewById(R.id.dodaj);
        dodaj.setOnClickListener(this);
    }


    @Override
    public void processFinish(String result) {
        finish();
        startActivity(getIntent());
    }

    @Override
    public void onClick(View view) {
        HashMap postData = new HashMap();
        postData.put("nazwa", nazwa.getText().toString());
        postData.put("kod", kod.getText().toString());
        postData.put("rodzaj", rodzaj.getText().toString());
        postData.put("cena", cena.getText().toString());
        PostResponseAsyncTask task2 = new PostResponseAsyncTask(this, postData);
        task2.execute("http://traveler95.nazwa.pl/jeden/client/add_Items.php");

        }
    }