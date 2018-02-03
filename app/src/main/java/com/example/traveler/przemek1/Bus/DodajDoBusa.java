package com.example.traveler.przemek1.Bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class DodajDoBusa extends AppCompatActivity implements AsyncResponse {

    String idbusa;
    String idprzedmiotu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_do_busa);


        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
                idbusa = extras.getString("idbusa");
        }



        HashMap postData2 = new HashMap();
        postData2.put("busid", idbusa);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/dodaj_do_busa.php");


    }

    ArrayList<Wiersz12> BusList = new ArrayList<>();


    @Override
    public void processFinish(String result)
    {
        if(result.equals(""))
        {
            Toast.makeText(this, "Nie ma nic do dodania", Toast.LENGTH_SHORT).show();
        }

        int i = 1;
        for (String retval1 : result.split(">"))
        {
            i=1;
            final Wiersz12 bus = new Wiersz12("", "","");
            for (String retval2 : retval1.split("-")) {
                if (i == 1) {
                    bus.setLewy(retval2);
                }
                if (i == 2) {
                    bus.setPrawyGora(retval2);
                }
                if (i == 3) {
                    bus.setPrawyDol(retval2);
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

                Wiersz12 transporter = BusList.get(position);
                idprzedmiotu = transporter.getPrawyDol();


                switch (position)
                {
                    default:
                        Intent in = new Intent(DodajDoBusa.this, DodajDoBusaPopup.class);
                        in.putExtra("idbusa",idbusa);
                        in.putExtra("idprzedmiotu",idprzedmiotu);

                        startActivity(in);
                        break;
                }
            }
        });
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

