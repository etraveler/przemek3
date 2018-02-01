package com.example.traveler.przemek1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EdytujPrzedmiot2 extends AppCompatActivity {



    String nazwa, rodzaj, cena, kod;
    TextView txtnazwa, txtcena, txtrodzaj, txtkod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_przedmiot2);

        Bundle extras = getIntent().getExtras();

        txtnazwa = (TextView) findViewById(R.id.txtnazwa);
        txtcena = (TextView) findViewById(R.id.txtcena);
        txtrodzaj = (TextView) findViewById(R.id.txtrodzaj);
        txtkod = (TextView) findViewById(R.id.txtkod);

        if (extras != null) {
            nazwa = extras.getString("nazwa");
            rodzaj = extras.getString("rodzaj");
            kod = extras.getString("kod");
            cena = extras.getString("cena");
        }
        txtnazwa.setText(nazwa);
        txtcena.setText(cena);
        txtrodzaj.setText(rodzaj);
        txtkod.setText(kod);


    }
}
