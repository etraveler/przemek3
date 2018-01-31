package com.example.traveler.przemek1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class lista extends ListActivity implements AsyncResponse, View.OnClickListener  {

    Button btngetpass;
    Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

String[] cars = {"kot", "pies", "as", "fsdf", "123212", "ppppp"};
String zwierzak="pantera";
cars[2]=zwierzak;




        btngetpass = (Button) findViewById(R.id.btngetpass);
        btngetpass.setOnClickListener(this);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(this);


    }
    int wiersz = 1;
    int pozycja=0;
    String[] cars = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    @Override
    public void processFinish(String result) {





        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, cars);
        getListView().setAdapter(adapter);


        cars[pozycja] = result;
        pozycja++;


    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btngetpass:


                while (wiersz<15) {
                    String wierszstring = wiersz + "";
                    HashMap postData = new HashMap();
                    postData.put("mobile1", "android1");
                    postData.put("numerwiersza", wierszstring);
                    PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                    task.execute("http://traveler95.nazwa.pl/jeden/client/tester.php");
                    wiersz++;
                }
                wiersz=1;
                pozycja=0;
                break;

            case R.id.btnback:
                Intent in = new Intent(this, Menu_robocze.class);
                startActivity(in);
                break;


        }
    }




}
