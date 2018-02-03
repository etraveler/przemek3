package com.example.traveler.przemek1.Bus;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class Zmien_ilosc extends AppCompatActivity implements AsyncResponse, View.OnClickListener {



    Button p10;
    Button p1;
    Button m10;
    Button m1;
    Button set;
    int ilosc=0;
    TextView textView9;
    String iloscstring;
    String iloscstara;
    String kod;
    String nazwa;
    String idprzedmiotu;
    String idbusa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zmien_ilosc);


        p10 = (Button) findViewById(R.id.p10);
        p10.setOnClickListener(this);
        p1 = (Button) findViewById(R.id.p1);
        p1.setOnClickListener(this);
        m10 = (Button) findViewById(R.id.m10);
        m10.setOnClickListener(this);
        m1 = (Button) findViewById(R.id.m1);
        m1.setOnClickListener(this);
        set = (Button) findViewById(R.id.set);
        set.setOnClickListener(this);
        textView9 = (TextView)findViewById(R.id.textView9);

        textView9.setText("0");


        //zmiana rozmiaru okienka
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .4));


        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            nazwa = extras.getString("nazwa");
            iloscstara = extras.getString("ilosc");
            kod = extras.getString("kod");
            idprzedmiotu = extras.getString("idprzedmiotu");
            idbusa = extras.getString("idbusa");
        }

    }


    @Override
    public void processFinish(String result) {

        finish();

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.p10:
                ilosc=ilosc+10;
                iloscstring = ilosc + "";
                textView9.setText(iloscstring);
                break;
            case R.id.p1:
                ilosc=ilosc+1;
                iloscstring = ilosc + "";
                textView9.setText(iloscstring);
                break;
            case R.id.m10:
                ilosc=ilosc-10;
                iloscstring = ilosc + "";
                textView9.setText(iloscstring);
                break;
            case R.id.m1:
                ilosc=ilosc-1;
                iloscstring = ilosc + "";
                textView9.setText(iloscstring);
                break;
            case R.id.set:
                HashMap postData2 = new HashMap();
                int intiloscstara = Integer.parseInt(iloscstara);
                ilosc = intiloscstara+ilosc;
                if (ilosc>0 || ilosc==0) {
                    iloscstring = ilosc + "";
                    postData2.put("ilosc", iloscstring);
                    postData2.put("idbus", idbusa);
                    postData2.put("idprzedmiot", idprzedmiotu);
                    PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
                    task.execute("http://traveler95.nazwa.pl/jeden/client/zmien_ilosc.php");
                }
                else
                {
                    Toast.makeText(this, "Ilość nie może być mniejsza od zera", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
