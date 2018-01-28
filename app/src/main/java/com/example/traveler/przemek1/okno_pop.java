package com.example.traveler.przemek1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

/**
 * Created by Traveler on 28.01.2018.
 */

public class okno_pop extends Activity implements View.OnClickListener{

    Button btnshow;
  //  final TextView tv = (TextView) findViewById(R.id.tv);
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okno_pop);

       btnshow = (Button) findViewById(R.id.btnshow);
       btnshow.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .3));



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("tekst");
         //   tv.setText("Your favorite : " + value);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.btnshow:
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("tekst");
                       tv.setText("nazwa przycisku: " + value);
                }
                break;
        }
    }

}