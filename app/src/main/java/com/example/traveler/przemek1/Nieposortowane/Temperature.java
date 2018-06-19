package com.example.traveler.przemek1.Nieposortowane;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.traveler.przemek1.Bus.DodajDoBusa;
import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Temperature extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    BarChart barChart;
    String data_wstecz_wyslana;
    String data_wstecz_odebrana;
    Button wstecz;
    // the labels that should be drawn on the XAxis

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        wstecz = (Button) findViewById(R.id.wstecz);
        wstecz.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Toast.makeText(this, "extrass!", Toast.LENGTH_SHORT).show();
            data_wstecz_odebrana = extras.getString("data_wstecz");
            HashMap postData = new HashMap();
            postData.put("mobile1", "android1");
            postData.put("data_wstecz", data_wstecz_odebrana);
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
            task.execute("http://traveler95.nazwa.pl/jeden/client/temperature3.php");

        }
        else {

            HashMap postData2 = new HashMap();
            postData2.put("mobile1", "android1");
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
            task.execute("http://traveler95.nazwa.pl/jeden/client/temperature.php");
        }

    }


    @Override
    public void processFinish(String result) {

        result = result.substring(0, result.length() - 1);

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();


        barChart = (BarChart) findViewById(R.id.barGraph);
        int n = 6;
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        int kot=1;
        int pies=1;
        int licznikDaty=0;
        int y=0;
        String godziny;


       final String[] daty = new String[30];
       final String[] quarters = new String[30];



     if (result.equals("pusto"))
        {

        }
        else
        {
            ListView mListView = (ListView) findViewById(R.id.listView);
            int i = 1;
            for (String retval1 : result.split(">")) // ten znak oddziela caly jeden wynik z bazy danych czyli: "id, time, date, temperature" od kolejnego wyniku, czyli dzieli stringa na wiersze
            {
                i=1;
                final Wiersz12 bus = new Wiersz12("", "", "");
                for (String retval2 : retval1.split("<")) {         // ten znak oddziela poszczegolne kolumny w tym jednym wyniku z bazy danych, czyli dzieli na kolumny
                    if (i == 1) {               // pierwsza iteracja, ale to 'id', którego nigdzie nie używamy

                    }
                    if (i == 2) {       //teraz bedzie wartosc 'time'

                        String str = retval2;               // tutaj sie zapisze do zmiennej 'str' string 'time', a potem skrocony o 3 ostatnie znaki, bo chyba ma styl np. 10:00:00
                        str = str.substring(0, str.length() - 3);


                        quarters[pies]=str;             // do tablicy 'quarters' bedzie zapisywana po kolei godzina
                        if (pies<24)
                        {
                            pies++;
                        }

                    }
                    if (i == 3) {               // 3 iteracja i teraz bedzie temperatura
                        if (kot<25)
                        {
                        float f = Float.parseFloat(retval2);    // rzutowanie int na float, ale chyba juz niepotrzebne, bo w bazie sa floatmi
                        barEntries.add(new BarEntry(kot, f));  // przypisanie danych do wykresu. 'kot' jako wartosc X czyli liczba 1 , 2, 3, a 'f' jako wartość Y, czyli temperatura

                            kot++;
                        }

                    }
                    if (i==4){                  //teraz powinna byc data sama
                        String zmiennaDate = retval2;       // przypisanie samej daty z 'retval2' do 'zmiennaDate'
                        zmiennaDate = zmiennaDate.substring(8);  // do zmiennej 'zmiennaDate', powinno się zapisać po 8 znaku w dacie, czyli sam dzien np. 11, 15, 16 itd.
                        data_wstecz_wyslana=retval2;
                        daty[licznikDaty]=zmiennaDate; // zapiszemy teraz kazdy dzien do zmiennej w tablicy
                         Toast.makeText(this, daty[licznikDaty], Toast.LENGTH_SHORT).show();
                        if(licznikDaty<24)
                        {
                            licznikDaty++;
                        }

                    }

                    i++;
                }
            }
        }


        BarDataSet set = new BarDataSet(barEntries, "Temperatura w ℃");

        BarData data = new BarData(set);    //tutaj sie rysuje wykres
        barChart.setDescription(null);
        barChart.invalidate();
        barChart.setData(data);
        data.setBarWidth(0.5f); // set custom bar width
        set.setColor(R.color.blue);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars

        barChart.setTouchEnabled(true);  // do dotykania
        barChart.setDragEnabled(true);  // do przesuwania

        Legend legend = barChart.getLegend();
        legend.setEnabled(true);
        legend.setFormSize(10f); // set the size of the legend forms/shapes
        legend.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        legend.setTextSize(12f);
        legend.setTextColor(Color.BLACK);
        legend.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        legend.setYEntrySpace(5f); // set the space between the legend entries on the y-axis


        String napis;
        Date date = new Date();
        napis = date.toString();





        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }


            public int getDecimalDigits() {
                return 0;
            }
        };


        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);


        barChart.invalidate(); // refresh






    }


    @Override
    public void onClick(View v) {

        Intent in = new Intent(Temperature.this, Temperature.class);
        in.putExtra("idbusa",data_wstecz_wyslana);




    }



    }






