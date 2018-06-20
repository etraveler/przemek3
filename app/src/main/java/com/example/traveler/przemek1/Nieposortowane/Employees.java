package com.example.traveler.przemek1.Nieposortowane;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.traveler.przemek1.R;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.Date;

public class Employees extends AppCompatActivity {

    BarChart barChart;
    // the labels that should be drawn on the XAxis

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        barChart = (BarChart) findViewById(R.id.barGraph);
        int n = 6;
        float m = 4;
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 23f));
        barEntries.add(new BarEntry(2f, 25f));
        barEntries.add(new BarEntry(3f, 28f));
        barEntries.add(new BarEntry(m, 18f));
        barEntries.add(new BarEntry(5f, 17f));
        barEntries.add(new BarEntry(6f, 9f));
        barEntries.add(new BarEntry(7f, 11f));
        barEntries.add(new BarEntry(8f, 18f));
        barEntries.add(new BarEntry(9f, 17f));
        barEntries.add(new BarEntry(10f, 29f));
        barEntries.add(new BarEntry(11f, 28f));
        barEntries.add(new BarEntry(12f, 6f));
        barEntries.add(new BarEntry(13f, 9f));
        barEntries.add(new BarEntry(14f, 12f));
        barEntries.add(new BarEntry(15f, 24f));
        barEntries.add(new BarEntry(16f, 18f));
        barEntries.add(new BarEntry(17f, 17f));
        barEntries.add(new BarEntry(18f, 21f));
        barEntries.add(new BarEntry(19f, 11f));
        barEntries.add(new BarEntry(20f, 18f));
        barEntries.add(new BarEntry(21f, 17f));
        barEntries.add(new BarEntry(22f, 20f));
        barEntries.add(new BarEntry(23f, 13f));
        barEntries.add(new BarEntry(24f, 18f));


        BarDataSet set = new BarDataSet(barEntries, "Temperature w ℃");

        BarData data = new BarData(set);
        barChart.setDescription(null);
        barChart.invalidate();
        barChart.setData(data);
        data.setBarWidth(0.5f); // set custom bar width
        data.setValueTextSize(8f); // set custom text size
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
        Toast.makeText(this,napis,Toast.LENGTH_LONG).show();

        // the labels that should be drawn on the XAxis
        final String[] quarters = new String[] { "q","09/06/18", "10/06/18", "11/06/18", "04:00", "13/06/18","Q","Q","08:00","Q","Q","Q","12:00","Q","Q","Q","16:00","Q","Q","Q","20:00","Q","Q","Q","00:00" };

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }

            // we don't draw numbers, so no decimal digits needed

            public int getDecimalDigits() {  return 0; }
        };

        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);



        barChart.invalidate(); // refresh
    }

      /*  GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series); */
    /*int number = 5;
        // generate Dates
        Calendar calendar = getInstance();
        Date d1 = calendar.getTime();
        calendar.add(DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(DATE,1 );
        Date d3 = calendar.getTime();
        calendar.add(DATE, 1);
        Date d4 = calendar.getTime();




        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 10),
                new DataPoint(d3, 3),
                new DataPoint(d4, 2)

        });
        graph.addSeries(series);

// set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graph.getGridLabelRenderer().setNumHorizontalLabels(4); // only 4 because of the space

// set manual x bounds to have nice steps
       // graph.getViewport().setMinX(d1.getTime());
       // graph.getViewport().setMinX(d2.getTime());
       // graph.getViewport().setMaxX(d3.getTime());
      //  graph.getViewport().setXAxisBoundsManual(true);

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
        graph.getGridLabelRenderer().setHumanRounding(false);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(70);


// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);

*/

    }



