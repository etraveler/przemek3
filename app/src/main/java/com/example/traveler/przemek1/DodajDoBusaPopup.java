package com.example.traveler.przemek1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class DodajDoBusaPopup extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    Button set;

    NumberPicker number;
    String idbusa;
    String idprzedmiotu;

int liczba=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_do_busa_popup);


        set = (Button) findViewById(R.id.set);
        set.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idbusa = extras.getString("idbusa");
            idprzedmiotu = extras.getString("idprzedmiotu");
        }


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .4));

        number = (NumberPicker) findViewById(R.id.number);

        number.setMinValue(0);
        number.setMaxValue(100);
        number.setWrapSelectorWheel(true);


        number.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            liczba=newVal;
            }
        });
    }

    @Override
    public void processFinish(String result) {
        Toast.makeText(this, "prawdopodobnie dodano xD", Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public void onClick(View v)
    {


                String liczbastring=liczba +"";

              HashMap postData = new HashMap();
                postData.put("ile", liczbastring);
                postData.put("idbusa", idbusa);
                postData.put("idprzedmiotu", idprzedmiotu);
                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://traveler95.nazwa.pl/jeden/client/dodaj_do_busa2.php");

    }
}