package com.example.traveler.przemek1.Dodatki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class EdytujDodatek2 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    String nazwa, rodzaj, cena, kod;
    TextView txtnazwa, txtcena, txtrodzaj, txtkod;
    EditText editnazwa, editcena, editrodzaj, editkod;
    Switch switchnazwa, switchcena, switchkod, switchrodzaj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_przedmiot2);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nazwa = extras.getString("nazwa");
            rodzaj = extras.getString("rodzaj");
            kod = extras.getString("kod");
            cena = extras.getString("cena");
        }

        txtnazwa = (TextView) findViewById(R.id.txtnazwa);
        txtcena = (TextView) findViewById(R.id.txtcena);
        txtrodzaj = (TextView) findViewById(R.id.txtrodzaj);
        txtkod = (TextView) findViewById(R.id.txtkod);

        editnazwa = (EditText) findViewById(R.id.editnazwa);
        editcena = (EditText) findViewById(R.id.editcena);
        editrodzaj = (EditText) findViewById(R.id.editrodzaj);
        editkod = (EditText) findViewById(R.id.editkod);

        Switch switchnazwa = (Switch) findViewById(R.id.switchnazwa);
        Switch switchcena = (Switch) findViewById(R.id.switchcena);
        Switch switchkod = (Switch) findViewById(R.id.switchkod);
        Switch switchrodzaj = (Switch) findViewById(R.id.switchrodzaj);


        switchnazwa.setOnCheckedChangeListener(this);
        switchcena.setOnCheckedChangeListener(this);
        switchkod.setOnCheckedChangeListener(this);
        switchrodzaj.setOnCheckedChangeListener(this);

        txtnazwa.setText(nazwa);
        txtcena.setText(cena);
        txtrodzaj.setText(rodzaj);
        txtkod.setText(kod);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (! isChecked) {
            switch (buttonView.getId()) {
                case R.id.switchnazwa:
                    editnazwa.setEnabled(false);
                    editnazwa.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    editnazwa.setText("");
                    break;
                case R.id.switchcena:
                    editcena.setEnabled(false);
                    editcena.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    editcena.setText("");
                    break;
                case R.id.switchrodzaj:
                    editrodzaj.setEnabled(false);
                    editrodzaj.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    editrodzaj.setText("");
                    break;
                case R.id.switchkod:
                    editkod.setEnabled(false);
                    editkod.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    editkod.setText("");
                    break;
            }
        } else {
            switch (buttonView.getId()) {
                case R.id.switchnazwa:
                    editnazwa.setEnabled(true);
                    editnazwa.setHintTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case R.id.switchcena:
                    editcena.setEnabled(true);
                    editcena.setHintTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case R.id.switchrodzaj:
                    editrodzaj.setEnabled(true);
                    editrodzaj.setHintTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case R.id.switchkod:
                    editkod.setEnabled(true);
                    editkod.setHintTextColor(getResources().getColor(R.color.colorAccent));
                    break;

            }
        }
    }
}