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
        String[] fruits = new String[] {
                "Japanese Persimmon",
                "Logowanie",
                "lista",
                "Malay Apple ",
                "Mamoncillo",
                "Persian lime"
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
                tv.setText("Your favorite : " + position + id + selectedItem);




                switch (position) {


                    case 1:
                        Intent in1 = new Intent(Bus1.this, Logowanie.class);
                        startActivity(in1);
                        break;
                    case 2:
                        Intent in2 = new Intent(Bus1.this, lista.class);
                        startActivity(in2);
                        break;
                }



            }
        });
    }
}