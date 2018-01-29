package com.example.traveler.przemek1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Zmien_ilosc extends AppCompatActivity implements View.OnClickListener {



    Button p10;
    Button p1;
    Button m10;
    Button m1;
    int ilosc=0;
    TextView textView9;


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
        textView9 = (TextView)findViewById(R.id.textView9);

        textView9.setText("wtff");


        //zmiana rozmiaru okienka
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .3));



    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.p10:
                ilosc=ilosc+10;
                String iloscstring = ilosc + "";
                textView9.setText(iloscstring);
                break;

            case R.id.p1:
                textView9.setText("ss");
                break;
            case R.id.m10:
                break;
            case R.id.m1:
                break;

        }
    }
}
