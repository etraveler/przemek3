package com.example.traveler.przemek1.Bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.traveler.przemek1.Dodatki.EdytujDodatek;
import com.example.traveler.przemek1.Dodatki.add_Items;
import com.example.traveler.przemek1.R;

public class Busy extends AppCompatActivity implements View.OnClickListener {


    Button btnlistabus, btnusunbus, btndodajbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busy);


        btnlistabus = (Button) findViewById(R.id.btnlistabus);
        btnlistabus.setOnClickListener(this);
        btnusunbus = (Button) findViewById(R.id.btnusunbus);
        btnusunbus.setOnClickListener(this);
        btndodajbus = (Button) findViewById(R.id.btndodajbus);
        btndodajbus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btnlistabus:
                Intent in1 = new Intent(this, ListaBus.class);
                startActivity(in1);
                break;
            case R.id.btnusunbus:
                Intent in2 = new Intent(this, UsunBus.class);
                startActivity(in2);
                break;
            case R.id.btndodajbus:
                Intent in3 = new Intent(this, DodajBusa.class);
                startActivity(in3);
                break;
        }
    }
}
