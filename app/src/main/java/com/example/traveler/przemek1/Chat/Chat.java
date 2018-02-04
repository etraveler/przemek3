package com.example.traveler.przemek1.Chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
import com.example.traveler.przemek1.Inne.checkToken;
import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;


public class Chat extends AppCompatActivity implements View.OnClickListener, AsyncResponse{


    Button btnwyslij, btnodswiez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btnwyslij = (Button) findViewById(R.id.btnwyslij);
        btnwyslij.setOnClickListener(this);
        btnodswiez = (Button) findViewById(R.id.btnodswiez);
        btnodswiez.setOnClickListener(this);


        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/wyswietl_chat.php");

        Intent check = new Intent(this, checkToken.class);
        startActivity(check);


    }

    ArrayList<Wiersz12> BusList = new ArrayList<>();


    @Override
    public void processFinish(String result)
    {

        if (result.equals("pusto"))
        {

        }
        else
        {
            ListView mListView = (ListView) findViewById(R.id.listView);
            BusList.clear();
            int i = 1;
            for (String retval1 : result.split(">"))
            {
                i=1;
                final Wiersz12 bus = new Wiersz12("", "", "");
                for (String retval2 : retval1.split("<")) {
                    if (i == 1) {
                        bus.setLewy(retval2);
                    }
                    if (i == 2) {
                        bus.setPrawyGora(retval2);
                        bus.setDodatkowy(retval2);
                    }
                    if (i == 3) {
                        bus.setPrawyDol(retval2);
                    }
                    i++;
                }
                BusList.add(bus);
            }

            Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout_chat, BusList);
            mListView.setAdapter(adapter);
        }
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnwyslij:
                Intent in = new Intent(this, DodajWiadomosc.class);
                startActivity(in);
                break;
            case R.id.btnodswiez:
                startActivity(getIntent());
                break;
        }
    }


    int i=0;
    @Override
    protected void onResume() {

        super.onResume();
        if (i>1) {
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    protected void onPause() {
        i++;
        super.onPause();
    }
}
