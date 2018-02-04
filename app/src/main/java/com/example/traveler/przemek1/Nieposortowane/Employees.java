package com.example.traveler.przemek1.Nieposortowane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.traveler.przemek1.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Employees extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        ListView lv = (ListView)findViewById(R.id.ListViewEmp);

        ArrayList<String> arrayEmployees = new ArrayList<>();

     //   arrayEmployees.addAll(Arrays.asList(getResources().getStringArray(R.array.array_emp)));

        adapter = new ArrayAdapter<String>(Employees.this, android.R.layout.simple_list_item_1, arrayEmployees);
        lv.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

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
}
