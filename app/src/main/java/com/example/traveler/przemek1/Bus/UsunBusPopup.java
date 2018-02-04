package com.example.traveler.przemek1.Bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class UsunBusPopup extends AppCompatActivity implements AsyncResponse, View.OnClickListener{




    Button btnusunbusa;
    String idbusa, nazwabusa, rejestracja;
    EditText txtusunbusa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usun_bus_popup);

        btnusunbusa = (Button) findViewById(R.id.btnusunbusa);
        btnusunbusa.setOnClickListener(this);
        txtusunbusa = (EditText) findViewById(R.id.txtusunbusa);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idbusa = extras.getString("idbusa");
            nazwabusa = extras.getString("nazwabusa");
            rejestracja = extras.getString("rejestracja");
        }



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 1), (int) (height * .4));
        getWindow().setGravity(Gravity.TOP);


    }


    @Override
    public void processFinish(String s) {

        if (s.equals("success"))
        {
            Toast.makeText(this, "usunięto", Toast.LENGTH_SHORT).show();
        }

        finish();

    }

    @Override
    public void onClick(View view) {

        String czy=txtusunbusa.getText().toString();
     //   Toast.makeText(this, czy, Toast.LENGTH_SHORT).show();
        if (czy.equals("usun busa")) {
            HashMap postData = new HashMap();
            postData.put("idbusa", idbusa);
            postData.put("nazwabusa", nazwabusa);
            postData.put("rejestracja", rejestracja);
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
            task.execute("http://traveler95.nazwa.pl/jeden/client/usun_busa.php");
        }
        else
        {
            Toast.makeText(this, "Niepoprawnie wpisany tekst", Toast.LENGTH_SHORT).show();
        }

    }
}
