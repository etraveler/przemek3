package com.example.traveler.przemek1.Bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
import com.example.traveler.przemek1.Inne.checkToken;
import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaBus extends AppCompatActivity implements AsyncResponse{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bus);
        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/listabus.php");

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
                int i = 1;
                for (String retval1 : result.split(">"))
                {
                    i=1;
                    final Wiersz12 bus = new Wiersz12("", "", "");
                    for (String retval2 : retval1.split("-")) {
                        if (i == 1) {
                            bus.setPrawyDol(retval2);
                        }
                        if (i == 2) {
                            bus.setPrawyGora("Rejestracja:");
                            bus.setDodatkowy(retval2);
                        }
                        if (i == 3) {
                            bus.setLewy(retval2);
                        }
                        i++;
                    }
                    BusList.add(bus);
                }
                     ListView mListView = (ListView) findViewById(R.id.listView);



                    Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout, BusList);
                    mListView.setAdapter(adapter);



                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                        {

                            Wiersz12 transporter=BusList.get(position);
                            String idbusa=transporter.getDodatkowy();
                            String nazwabusa=transporter.getLewy();
                            String rejestracja=transporter.getPrawyDol();

                            switch (position)
                            {
                                default:
                                    Intent in = new Intent(ListaBus.this, BusZawartosc.class);
                                    in.putExtra("tekst1",idbusa);
                                    in.putExtra("tekst2",nazwabusa);
                                    in.putExtra("tekst3",rejestracja);
                                    startActivity(in);
                                    break;
                            }
                        }
                    });
    }
    }
}

