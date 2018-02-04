package com.example.traveler.przemek1.Chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveler.przemek1.Inne.tokenGlobal;
import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

import static android.view.Gravity.TOP;

public class DodajWiadomosc extends AppCompatActivity implements View.OnClickListener, AsyncResponse {



    Button btnwyslij;
    EditText wiadomosc;
    String token2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wiadomosc);

        String token = ((tokenGlobal) this.getApplication()).getSomeVariable();
        btnwyslij = (Button) findViewById(R.id.btnwyslij);
        btnwyslij.setOnClickListener(this);

        wiadomosc = (EditText) findViewById(R.id.wiadomosc);



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .4));
        getWindow().setGravity(TOP);



        token2=token;

    }

    @Override
    public void onClick(View view) {


        HashMap postData = new HashMap();
        postData.put("wiadomosc", wiadomosc.getText().toString());
        postData.put("token", token2);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://traveler95.nazwa.pl/jeden/client/dodaj_wiadomosc.php");
    }

    @Override
    public void processFinish(String s)
    {
        finish();
    }
}
