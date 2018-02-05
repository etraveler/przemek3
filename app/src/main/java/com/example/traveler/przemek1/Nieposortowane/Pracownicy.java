package com.example.traveler.przemek1.Nieposortowane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
import com.example.traveler.przemek1.Inne.checkToken;
import com.example.traveler.przemek1.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class Pracownicy extends AppCompatActivity implements AsyncResponse {
    ArrayAdapter<Wiersz12ListAdapter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pracownicy);
        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/Pracownicy.php");

        Intent check = new Intent(this, checkToken.class); // sprawdzanie tokena
        startActivity(check);

    }

    ArrayList<Wiersz12> EmployeesList = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();
        //ListView mListView = (ListView) findViewById(R.id.listView);
     //  final Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout, EmployeesList);
     //   mListView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void processFinish(String result) {
        if (result.equals("pusto")) {

        } else {
            int i = 1;
            for (String retval1 : result.split(">")) {
                i = 1;
                final Wiersz12 bus = new Wiersz12("", "", "");
                for (String retval2 : retval1.split("-")) {
                    if (i == 1) {
                        bus.setLewy(retval2);
                    }
                    if (i == 2) {
                        bus.setPrawyGora("Telefon: " + retval2);
                        bus.setDodatkowy(retval2);
                    }
                    if (i == 3) {
                        bus.setPrawyDol("Email: " + retval2);
                    }
                    i++;
                }
                EmployeesList.add(bus);
            }
            ListView mListView = (ListView) findViewById(R.id.listView);


            Wiersz12ListAdapter adapter = new Wiersz12ListAdapter(this, R.layout.adapter_view_layout, EmployeesList);
            mListView.setAdapter(adapter);
        }
    }


}
/*
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {

                    Wiersz12 transporter=EmployeesList.get(position);
                    String idbusa=transporter.getDodatkowy();
                    String nazwabusa=transporter.getLewy();
                    String rejestracja=transporter.getPrawyDol();

                    switch (position)
                    {


                        default:
                            Intent in = new Intent(Pracownicy.this, BusZawartosc.class);
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

*/