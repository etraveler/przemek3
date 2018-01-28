package com.example.traveler.przemek1;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bus1 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus1);


        // Get reference of widgets from XML layout
        ListView lv = (ListView) findViewById(R.id.lv);
        final TextView tv = (TextView) findViewById(R.id.tv);

        // Initializing a new String Array
        final String[] fruits = new String[] {
                "tylko zmiena tekst na gorze",
                "Cofnij",
                "lista",
                "wyskakujace okno",
                "drugie wyskakujace okno",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko...",
                "kolejne okienko..."
        };

        // Create a List from String Array elements
        List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        // Create a ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        // Populate ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        // Set an item click listener for ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item text on TextView
                tv.setText("pozycja: " + position + " id: " + id +" "+ selectedItem);




                switch (position) {


                    case 0:
                        break;
                    case 1:
                        Intent in1 = new Intent(Bus1.this, Ekran1.class);
                        startActivity(in1);
                        break;
                    case 2:
                        Intent in2 = new Intent(Bus1.this, lista.class);
                        startActivity(in2);
                        break;
                    case 3:
                        Intent in3 = new Intent(Bus1.this, okno_pop.class);
                        in3.putExtra("tekst",fruits[position]);
                        in3.putExtra("tekst2",fruits[1]);
                        startActivity(in3);
                        break;
                    case 4:
                        Intent in4 = new Intent(Bus1.this, okno_pop.class);
                        in4.putExtra("tekst",fruits[position]);
                        startActivity(in4);
                        break;
                    default:
                        Intent in5 = new Intent(Bus1.this, okno_pop.class);
                        in5.putExtra("tekst",fruits[position]);
                        startActivity(in5);
                        break;
                }



            }
        });
    }
}