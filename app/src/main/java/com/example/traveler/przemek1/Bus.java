package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class Bus extends AppCompatActivity implements AsyncResponse {

    TextView tekst1;
    TextView tekst2;
    TextView tekst3;
    String value1;
    String value2;
    String value3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        tekst1 = (TextView) findViewById(R.id.tekst1);
        tekst2 = (TextView) findViewById(R.id.tekst2);
        tekst3 = (TextView) findViewById(R.id.tekst3);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            value1 = extras.getString("tekst1");
            value2 = extras.getString("tekst2");
            value3 = extras.getString("tekst3");
            tekst1.setText("Bus o id: " + value1);
            tekst2.setText("Marka: " + value2);
            tekst3.setText("Rejestracja: " + value3);
        }


        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        postData2.put("idbusa", value1);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/zawartoscbus.php");


    }

    ArrayList<Autobus> BusList = new ArrayList<>();


    @Override
    public void processFinish(String result)
    {

        int i = 1;
        for (String retval1 : result.split(">"))
        {
            i=1;
            final Autobus bus = new Autobus("", "", "");
            for (String retval2 : retval1.split("-")) {
                if (i == 1) {
                    bus.setRejestracja(retval2);
                }
                if (i == 2) {
                    bus.setIdentyfikator(retval2);
                }
                if (i == 3) {
                    bus.setMarka(retval2);
                }
                i++;
            }
            BusList.add(bus);
        }
        ListView mListView = (ListView) findViewById(R.id.listView);



        BusListAdapter adapter = new BusListAdapter(this, R.layout.adapter_view_layout, BusList);
        mListView.setAdapter(adapter);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Autobus transporter=BusList.get(position);
                String idkogos=transporter.getIdentyfikator();
                String marka=transporter.getMarka();
                String rejestracja=transporter.getRejestracja();

                switch (position)
                {


                    default:
                        Intent in = new Intent(Bus.this, Zmien_ilosc.class);
                        in.putExtra("tekst1",idkogos);
                        in.putExtra("tekst2",marka);
                        in.putExtra("tekst3",rejestracja);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}










