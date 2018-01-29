package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class Bus extends AppCompatActivity implements AsyncResponse {

    TextView tekst1;
    TextView tekst2;
    TextView tekst3;
    int wiersz = 1;
    int zapytanie = 0;
    String ile_pozycji = "3";
    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        tekst1 = (TextView) findViewById(R.id.tekst1);
        tekst2 = (TextView) findViewById(R.id.tekst2);
        tekst3 = (TextView) findViewById(R.id.tekst3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value1 = extras.getString("tekst1");
            String value2 = extras.getString("tekst2");
            String value3 = extras.getString("tekst3");
            tekst1.setText("Bus o id: " + value1);
            tekst2.setText("Marka: " + value2);
            tekst3.setText("Rejestracja: " + value3);
        }


        HashMap postData1 = new HashMap();
        postData1.put("tabela", "tbl_bus");
        PostResponseAsyncTask task1 = new PostResponseAsyncTask(this, postData1);
        task1.execute("http://traveler95.nazwa.pl/jeden/client/ilosc_pozycji.php");


        String wierszstring = wiersz + "";
        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        postData2.put("numerwiersza", wierszstring);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/bustester.php");


    }

    ArrayList<Autobus> peopleList = new ArrayList<>();
    int foo = 3;


    @Override
    public void processFinish(String result) {

        switch (zapytanie) {
            case 0:
                ile_pozycji = result;
                foo = Integer.parseInt(ile_pozycji);
                zapytanie = 1;
                String fooo = foo + "";
                Toast.makeText(this, fooo, Toast.LENGTH_SHORT).show();
                break;

            case 1:
                wiersz++;
                int i = 1;
                final Autobus osoba = new Autobus("", "", "");
                for (String retval : result.split("-")) {
                    if (i == 1) {
                        osoba.setSex(retval);
                    }
                    if (i == 2) {
                        osoba.setIdentyfikator(retval);
                    }
                    if (i == 3) {
                        osoba.setName(retval);
                    }
                    i++;
                }
                peopleList.add(osoba);
                ListView mListView = (ListView) findViewById(R.id.listView);
                number++;


                if (wiersz <= foo) {
                    String wierszstring = wiersz + "";
                    HashMap postData2 = new HashMap();
                    postData2.put("mobile1", "android1");
                    postData2.put("numerwiersza", wierszstring);
                    PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
                    task.execute("http://traveler95.nazwa.pl/jeden/client/bustester.php");
                }


                if (wiersz == foo + 1) {
                    BusListAdapter adapter = new BusListAdapter(this, R.layout.adapter_view_layout, peopleList);
                    mListView.setAdapter(adapter);


                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Autobus transporter = peopleList.get(position);
                            String idkogos = transporter.getIdentyfikator();
                            String marka = transporter.getName();
                            String rejestracja = transporter.getSex();

                            switch (position) {


                                default:
                                    Intent in = new Intent(Bus.this, Bus_zmien.class);
                                    in.putExtra("tekst1", idkogos);
                                    in.putExtra("tekst2", marka);
                                    in.putExtra("tekst3", rejestracja);
                                    startActivity(in);
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }


}


















