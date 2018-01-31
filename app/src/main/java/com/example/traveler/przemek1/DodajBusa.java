package com.example.traveler.przemek1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class DodajBusa extends AppCompatActivity implements View.OnClickListener, AsyncResponse{



    Button dodaj;
    TextView nazwaBusa, rejestracja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_busa);

        nazwaBusa = (EditText) findViewById(R.id.nazwaBusa);
        rejestracja = (EditText) findViewById(R.id.rejestracja);

        dodaj = (Button) findViewById(R.id.dodaj);
        dodaj.setOnClickListener(this);




    }


    @Override
    public void processFinish(String result) {
finish();
    }


    @Override
    public void onClick(View view) {

        int nazwadlugosc = nazwaBusa.getText().length();
        int rejestracjadlugosc = rejestracja.getText().length();



        if (nazwadlugosc<3 || rejestracjadlugosc<3 || nazwadlugosc>11 || rejestracjadlugosc>8)
        {
            Toast.makeText(this, "Nieprawidłowa długość nazwy lub rejestracji", Toast.LENGTH_SHORT).show();
        }
        else {

            HashMap postData = new HashMap();
            postData.put("nazwa", nazwaBusa.getText().toString());
            postData.put("rejestracja", rejestracja.getText().toString());
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
            task.execute("http://traveler95.nazwa.pl/jeden/client/dodaj_busa.php");
        }
    }
}
