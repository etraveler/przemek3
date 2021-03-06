package com.example.traveler.przemek1.Bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.traveler.przemek1.R;
import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class BusZawartosc extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    TextView tekst2;
    TextView tekst3;
    String value1;
    String value2;
    String value3;
    Button btnodswiez;
    Button btndodaj;
    String idprzedmiotu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_zawartosc);


        btnodswiez = (Button) findViewById(R.id.btnodswiez);
        btnodswiez.setOnClickListener(this);
        btndodaj = (Button) findViewById(R.id.btndodaj);
        btndodaj.setOnClickListener(this);

        tekst2 = (TextView) findViewById(R.id.tekst2);
        tekst3 = (TextView) findViewById(R.id.tekst3);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            value1 = extras.getString("tekst1");
            value2 = extras.getString("tekst2");
            value3 = extras.getString("tekst3");
            tekst2.setText(value2);
            tekst3.setText("Rejestracja: " + value3);
        }

        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        postData2.put("idbusa", value1);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/zawartoscbus.php");


    }



    ArrayList<Wiersz12> BusList = new ArrayList<>();

    @Override
    public void processFinish(String result) {

        if (result == "") {

        } else {
            int i = 1;
            for (String retval1 : result.split(">")) {
                i = 1;
                final Wiersz12 bus = new Wiersz12("", "", "");
                for (String retval2 : retval1.split("-")) {
                    if (i == 1) {
                        bus.setPrawyDol("Kod: "+retval2);
                    }
                    if (i == 2) {
                        bus.setLewy(retval2);
                    }
                    if (i == 3) {
                        bus.setPrawyGora("Ilość: "+retval2);
                        bus.setDodatkowy2(retval2);
                    }
                    if (i == 4) {
                        bus.setDodatkowy(retval2);
                    }
                    i++;
                }
                BusList.add(bus);
            }
            ListView mListView = (ListView) findViewById(R.id.listView);


            Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout, BusList);
            mListView.setAdapter(adapter);


            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Wiersz12 transporter = BusList.get(position);
                    String nazwa = transporter.getLewy();
                    String ilosc = transporter.getDodatkowy2();
                    String kod = transporter.getPrawyDol();
                    idprzedmiotu = transporter.getDodatkowy();

                    switch (position) {


                        default:
                            Intent in = new Intent(BusZawartosc.this, Zmien_ilosc.class);
                            in.putExtra("nazwa", nazwa);
                            in.putExtra("ilosc", ilosc);
                            in.putExtra("kod", kod);
                            in.putExtra("idprzedmiotu", idprzedmiotu);
                            in.putExtra("idbusa", value1);
                            startActivity(in);
                            break;
                    }

                }
            });
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnodswiez:
                finish();
                startActivity(getIntent());
                break;

            case R.id.btndodaj:
                Intent in1 = new Intent(BusZawartosc.this, DodajDoBusa.class);
                in1.putExtra("idbusa", value1);
                startActivity(in1);
                break;
        }

    }



    int i=0;


    @Override
    protected void onResume() {

        super.onResume();
        if (i==1) {
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    protected void onPause() {
        i=1;
        super.onPause();
    }
}













