package com.example.traveler.przemek1.Dodatki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz22ListAdapter;
import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class EdytujDodatek extends AppCompatActivity implements AsyncResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_edytuj_przedmiot);



        HashMap postData2 = new HashMap();
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/wszystkie_przedmioty.php");
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
                        bus.setLewygora(retval2);
                    }
                    if (i == 2) {
                        bus.setLewydol(retval2);
                    }
                    if (i == 3) {
                        bus.setPrawyGora("Rodzaj: "+retval2);
                        bus.setDodatkowy2(retval2);
                    }
                    if (i == 4) {
                        bus.setPrawyDol("Cena: "+retval2+" zł");
                        bus.setDodatkowy(retval2);
                    }
                    i++;
                }
                BusList.add(bus);
            }
            ListView mListView = (ListView) findViewById(R.id.listView);


            Wiersz22ListAdapter adapter = new Wiersz22ListAdapter(this, R.layout.adapter_view_layout2, BusList);
            mListView.setAdapter(adapter);


            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Wiersz12 transporter = BusList.get(position);
                    String nazwa = transporter.getLewygora();
                    String rodzaj = transporter.getDodatkowy2();
                    String cena = transporter.getDodatkowy();
                    String kod = transporter.getLewydol();

                    switch (position) {


                        default:
                            Intent in = new Intent(EdytujDodatek.this, EdytujDodatek2.class);
                            in.putExtra("nazwa", nazwa);
                            in.putExtra("rodzaj", rodzaj);
                            in.putExtra("cena", cena);
                            in.putExtra("kod", kod);
                            startActivity(in);
                            break;
                    }

                }
            });
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





