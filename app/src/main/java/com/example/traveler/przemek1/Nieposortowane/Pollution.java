package com.example.traveler.przemek1.Nieposortowane;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.traveler.przemek1.Inne.Wiersz12;
import com.example.traveler.przemek1.Inne.Wiersz12ListAdapter;
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

public class Pollution extends AppCompatActivity implements AsyncResponse{

    BarChart barChart;
    // the labels that should be drawn on the XAxis

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pollution);


        HashMap postData2 = new HashMap();
        postData2.put("mobile1", "android1");
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData2);
        task.execute("http://traveler95.nazwa.pl/jeden/client/pogoda/pollution.php");


    }


    @Override
    public void processFinish(String result) {

        result = result.substring(0, result.length() - 1);


        barChart = (BarChart) findViewById(R.id.barGraph);
        int n = 6;
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        int kot=1;
        int pies=0;

        String godziny;

        final String[] quarters = new String[30];

        if (result.equals("pusto"))
        {

        }
        else
        {
            ListView mListView = (ListView) findViewById(R.id.listView);
            int i = 1;
            for (String retval1 : result.split(">"))
            {
                i=1;
                final Wiersz12 bus = new Wiersz12("", "", "");
                for (String retval2 : retval1.split("<")) {
                    if (i == 1) {

                    }
                    if (i == 2) {

                        String str = retval2;
                        str = str.substring(0, str.length() - 3);


                        quarters[pies]=str;
                        if (pies<24)
                        {
                            pies++;
                        }
                    }
                    if (i == 3) {
                        if (kot<25)
                        {
                            float f = Float.parseFloat(retval2);
                            barEntries.add(new BarEntry(kot, f));
                            kot++;
                        }

                    }
                    i++;
                }
            }
        }



        BarDataSet set = new BarDataSet(barEntries, "Pył zawieszony PM2.5 μg/m³ ");

        BarData data = new BarData(set);
        barChart.setDescription(null);
        barChart.invalidate();
        barChart.setData(data);
        set.setColor(R.color.colorPrimaryDark);
        data.setBarWidth(0.5f); // set custom bar width
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


}






