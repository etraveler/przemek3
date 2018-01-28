package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaBus extends AppCompatActivity implements AsyncResponse, View.OnClickListener{


    Button btnwczytaj;
    int number=1;
    String ile_pozycji="3";
    int zapytanie=0;
    int wiersz=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bus);


        btnwczytaj = (Button) findViewById(R.id.btnwczytaj);
        btnwczytaj.setOnClickListener((View.OnClickListener) this);


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
    int foo=3;



    @Override
    public void processFinish(String result)
    {

        switch (zapytanie) {
            case 0:
                ile_pozycji = result;
                foo = Integer.parseInt(ile_pozycji);
                zapytanie = 1;
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


                if (wiersz==foo+1)
                {
                    BusListAdapter adapter = new BusListAdapter(this, R.layout.adapter_view_layout, peopleList);
                    mListView.setAdapter(adapter);



                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Autobus ktos=peopleList.get(position);
                            String idkogos=ktos.getIdentyfikator();

                            switch (position) {


                                default:
                                    Intent in = new Intent(ListaBus.this, okno_pop.class);
                                    in.putExtra("tekst",idkogos);
                                    startActivity(in);
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }


    @Override
    public void onClick(View v)
    {


        switch (v.getId()) {


            case R.id.btnwczytaj:
                HashMap postData1 = new HashMap();
                postData1.put("tabela", "tbl_bus");
                PostResponseAsyncTask task1 = new PostResponseAsyncTask(this, postData1);
                task1.execute("http://traveler95.nazwa.pl/jeden/client/ilosc_pozycji.php");
                zapytanie=0;
                break;


        }
    }
}
