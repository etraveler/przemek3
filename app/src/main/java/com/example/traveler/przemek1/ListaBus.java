package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaBus extends AppCompatActivity implements AsyncResponse{


    int number=1;
    String ile_pozycji="3";
    int zapytanie=0;
    int wiersz=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bus);


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

    ArrayList<Autobus> BusList = new ArrayList<>();
    int foo=0;


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
                final Autobus bus = new Autobus("", "", "");
                for (String retval : result.split("-")) {
                    if (i == 1) {
                        bus.setRejestracja(retval);
                    }
                    if (i == 2) {
                        bus.setIdentyfikator(retval);
                    }
                    if (i == 3) {
                        bus.setMarka(retval);
                    }
                    i++;
                }
                BusList.add(bus);
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
                    BusListAdapter adapter = new BusListAdapter(this, R.layout.adapter_view_layout, BusList);
                    mListView.setAdapter(adapter);



                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Autobus transporter=BusList.get(position);
                            String idkogos=transporter.getIdentyfikator();
                            String marka=transporter.getMarka();
                            String rejestracja=transporter.getRejestracja();

                            switch (position) {


                                default:
                                    Intent in = new Intent(ListaBus.this, Bus.class);
                                    in.putExtra("tekst1",idkogos);
                                    in.putExtra("tekst2",marka);
                                    in.putExtra("tekst3",rejestracja);
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
