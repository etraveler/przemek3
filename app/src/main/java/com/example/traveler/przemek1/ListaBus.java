package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaBus extends AppCompatActivity implements AsyncResponse, View.OnClickListener{


    int informacja=3;
    int wiersz=1;
    Button btnwczytaj;
    int number=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bus);


        btnwczytaj = (Button) findViewById(R.id.btnwczytaj);
        btnwczytaj.setOnClickListener((View.OnClickListener) this);


        // ArrayList<Person> peopleList = new ArrayList<>();
      //  ListView mListView = (ListView) findViewById(R.id.listView);




        while (wiersz<6) {
            String wierszstring = wiersz + "";
            String informacjastring = informacja + "";
            HashMap postData2 = new HashMap();
            postData2.put("mobile1", "android1");
            postData2.put("numerwiersza", wierszstring);
            postData2.put("info", informacjastring);
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
            task.execute("http://traveler95.nazwa.pl/jeden/client/bustester.php");
            wiersz++;
            informacja++;
            if (informacja == 3)
            {
                informacja=1;
            }
        }






/*
      while (number<10)
        {
            String numerstring = number + "";
            Person osoba = new Person("John", numerstring,"Male");
            peopleList.add(osoba);
            number++;
        }


        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
        */
    }

    ArrayList<Person> peopleList = new ArrayList<>();

    @Override
    public void processFinish(String result) {

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();


          ListView mListView = (ListView) findViewById(R.id.listView);

            String numerstring = number + "";
            Person osoba = new Person(result+1, result, "Male");
            peopleList.add(osoba);
            number++;


if(number==6) {
    PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
    mListView.setAdapter(adapter);
}
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnwczytaj:
                HashMap postData1 = new HashMap();
                postData1.put("tabela", "tbl_bus");
                PostResponseAsyncTask task1 = new PostResponseAsyncTask(this, postData1);
                task1.execute("http://traveler95.nazwa.pl/jeden/client/ilosc_poozycji.php");
                break;


        }
        }
}
