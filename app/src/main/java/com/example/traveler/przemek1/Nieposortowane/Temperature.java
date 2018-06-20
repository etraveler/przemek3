package com.example.traveler.przemek1.Nieposortowane;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.traveler.przemek1.Glowne.Menu_pogoda;
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
    String zmiana_daty_wstecz_wyslana;
    String zmiana_daty_do_przodu_wyslana;
    String zmiana_daty_odebrana;
    Button btn_wstecz;
    Button btn_do_przodu;
    Button btn_menu;
    String wstecz_czy_naprzod_odebrane;
    // the labels that should be drawn on the XAxis

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        btn_wstecz = (Button) findViewById(R.id.btn_wstecz);
        btn_wstecz.setOnClickListener(this);
        btn_do_przodu = (Button) findViewById(R.id.btn_do_przodu);
        btn_do_przodu.setOnClickListener(this);
        btn_menu = (Button) findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            zmiana_daty_odebrana = extras.getString("zmiana_daty_wyslana");
            wstecz_czy_naprzod_odebrane =  extras.getString("wstecz_czy_naprzod");
            HashMap postData = new HashMap();
            Toast.makeText(this, zmiana_daty_odebrana, Toast.LENGTH_SHORT).show();
            postData.put("mobile1", "android1");
            postData.put("zmiana_daty", zmiana_daty_odebrana);
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
            task.execute("http://traveler95.nazwa.pl/jeden/client/pogoda/temperature2.php");

        }
        else {

            HashMap postData2 = new HashMap();
            postData2.put("mobile1", "android1");
            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
            task.execute("http://traveler95.nazwa.pl/jeden/client/pogoda/temperature.php");
        }

    }


    @Override
    public void processFinish(String result) {

        result = result.substring(0, result.length() - 1);



        barChart = (BarChart) findViewById(R.id.barGraph);
        int n = 6;
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        int licznik_x=1;
        int licznik_quarters=1;
        int licznikDaty=0;
        int y=0;
        String godziny;


       final String[] daty = new String[30];
       final String[] quarters = new String[30];



     if (result.equals("pust"))
        {

            String zmiana_daty_odebrana2;
            String miesiac_rok2;
        if (wstecz_czy_naprzod_odebrane.equals("a")) {


            zmiana_daty_wstecz_wyslana = zmiana_daty_odebrana;

            zmiana_daty_odebrana2 = zmiana_daty_odebrana.substring(8);
            int dzisiaj_dzien = Integer.parseInt(zmiana_daty_odebrana2);                   //zmiana daty na dzien wcześniej
            int nastepny_dzien = dzisiaj_dzien + 1;                                //zmiana daty na dzien wcześniej
            String nastepny_dzien_string = Integer.toString(nastepny_dzien);    //zmiana daty na dzien wcześniej
            miesiac_rok2 = zmiana_daty_odebrana.substring(0, 8);                            //zmiana daty na dzien wcześniej
            String jutrzejsza_data2 = miesiac_rok2 + nastepny_dzien_string;             //zmiana daty na dzien wcześniej
            zmiana_daty_do_przodu_wyslana = jutrzejsza_data2;

        }
        else if (wstecz_czy_naprzod_odebrane.equals("b")) {

            zmiana_daty_do_przodu_wyslana = zmiana_daty_odebrana;

            zmiana_daty_odebrana2 = zmiana_daty_odebrana.substring(8);
            int dzisiaj_dzien = Integer.parseInt(zmiana_daty_odebrana2);                   //zmiana daty na dzien wcześniej
            int wczoraj_dzien = dzisiaj_dzien - 1;                                //zmiana daty na dzien wcześniej
            String wczoraj_dzien_string = Integer.toString(wczoraj_dzien);    //zmiana daty na dzien wcześniej
            miesiac_rok2 = zmiana_daty_odebrana.substring(0, 8);                            //zmiana daty na dzien wcześniej
            String wczorajsza_data2 = miesiac_rok2 + wczoraj_dzien_string;             //zmiana daty na dzien wcześniej
            zmiana_daty_wstecz_wyslana = wczorajsza_data2;


        }
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


                        quarters[licznik_quarters]=str;             // do tablicy 'quarters' bedzie zapisywana po kolei godzina
                        if (licznik_quarters<24)
                        {
                            licznik_quarters++;
                        }

                    }
                    if (i == 3) {               // 3 iteracja i teraz bedzie temperatura
                        if (licznik_x<25)
                        {
                        float f = Float.parseFloat(retval2);    // rzutowanie int na float, ale chyba juz niepotrzebne, bo w bazie sa floatmi
                        barEntries.add(new BarEntry(licznik_x, f));  // przypisanie danych do wykresu. 'licznik_x' jako wartosc X czyli liczba 1 , 2, 3, a 'f' jako wartość Y, czyli temperatura

                            licznik_x++;
                        }

                    }
                    if (i==4){                  //teraz powinna byc data sama
                        String zmiennaDate = retval2;       // przypisanie samej daty z 'retval2' do 'zmiennaDate'
                        zmiennaDate = zmiennaDate.substring(8);  // do zmiennej 'zmiennaDate', powinno się zapisać po 8 znaku w dacie, czyli sam dzien np. 11, 15, 16 itd.



                        int dzisiejszy_dzien = Integer.parseInt(zmiennaDate);                   //zmiana daty na dzien wcześniej
                        int wczorajszy_dzien=dzisiejszy_dzien-1;                                //zmiana daty na dzien wcześniej
                        String wczorajszy_dzien_string = Integer.toString(wczorajszy_dzien);    //zmiana daty na dzien wcześniej
                        String miesiac_rok = retval2.substring(0,8);                            //zmiana daty na dzien wcześniej
                        String wczorajsza_data=miesiac_rok+wczorajszy_dzien_string;             //zmiana daty na dzien wcześniej
                        zmiana_daty_wstecz_wyslana=wczorajsza_data;                             //zmiana daty na dzien wcześniej

                        int jutrzejszy_dzien=dzisiejszy_dzien+1;                                //zmiana daty na dzien później
                        String jutrzejszy_dzien_string = Integer.toString(jutrzejszy_dzien);    //zmiana daty na dzien później
                        String jutrzejsza_data=miesiac_rok+jutrzejszy_dzien_string;             //zmiana daty na dzien później
                        zmiana_daty_do_przodu_wyslana=jutrzejsza_data;                          //zmiana daty na dzien później


                        daty[licznikDaty]=zmiennaDate; // zapiszemy teraz kazdy dzien do zmiennej w tablicy
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

        String wstecz_czy_naprzod; // a oznacza wsrttecz | b oznacza naprzód

        switch (v.getId()) {
            case R.id.btn_wstecz:
                Intent in = new Intent(Temperature.this, Temperature.class);
                wstecz_czy_naprzod="a";
                in.putExtra("zmiana_daty_wyslana", zmiana_daty_wstecz_wyslana);
                in.putExtra("wstecz_czy_naprzod", wstecz_czy_naprzod);
                startActivity(in);
                break;

            case R.id.btn_do_przodu:
                Intent in2 = new Intent(Temperature.this, Temperature.class);
                wstecz_czy_naprzod="b";
                in2.putExtra("zmiana_daty_wyslana", zmiana_daty_do_przodu_wyslana);
                in2.putExtra("wstecz_czy_naprzod", wstecz_czy_naprzod);
                startActivity(in2);
                break;

            case R.id.btn_menu:
                Intent in3 = new Intent(Temperature.this, Menu_pogoda.class);
                startActivity(in3);
                break;


        }

    }

    }






