package com.example.traveler.przemek1.Dodatki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.traveler.przemek1.R;

public class Dodatki extends AppCompatActivity implements View.OnClickListener {

    Button btnedytujdodatek;
    Button btndodajdodatek;
    Button btnusundodatek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodatki);

        btnedytujdodatek = (Button) findViewById(R.id.btnedytujdodatek);
        btnedytujdodatek.setOnClickListener(this);
        btndodajdodatek = (Button) findViewById(R.id.btndodajdodatek);
        btndodajdodatek.setOnClickListener(this);
        btnusundodatek = (Button) findViewById(R.id.btnusundodatek);
        btnusundodatek.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnedytujdodatek:
                Intent in1 = new Intent(this, EdytujDodatek.class);
                startActivity(in1);
                break;
            case R.id.btndodajdodatek:
                Intent in2 = new Intent(this, add_Items.class);
                startActivity(in2);
                break;
            case R.id.btnusundodatek:
               // Intent in3 = new Intent(this, UsunDodatek.class);
              //  startActivity(in3);
                break;

        }
    }
}
