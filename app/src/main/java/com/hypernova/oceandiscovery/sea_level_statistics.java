package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.card.MaterialCardView;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sea_level_statistics extends AppCompatActivity {

    LineChart lineChart;
    List<String> xValues;
    MaterialCardView next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea_level_statistics);

        lineChart = findViewById(R.id.lineChart);
        next_btn = findViewById(R.id.next_btn);

        Animation button_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                finish();
            }
        });

        Description description = new Description();
        description.setText("Sea Level Rising every 20 years");
        description.setPosition(150f,15f);
        lineChart.setDescription(description);
        lineChart.getAxisRight().setDrawLabels(false);

        xValues = Arrays.asList("2010","2012","2014","2016","2018","2020");

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
        xAxis.setLabelCount(10);
        xAxis.setGranularity(1f);

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMinimum(-100f);
        yAxis.setAxisMaximum(100f);
        yAxis.setAxisLineWidth(2f);
        yAxis.setLabelCount(50);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0,37.52f));
        entries.add(new Entry(1,33.86f));
        entries.add(new Entry(2,38.91f));
        entries.add(new Entry(3,35.21f));
        entries.add(new Entry(4,48.95f));
        entries.add(new Entry(5,44.35f));
        entries.add(new Entry(6,45.81f));
        entries.add(new Entry(7,39.71f));
        entries.add(new Entry(8,56.59f));
        entries.add(new Entry(9,51.41f));
        entries.add(new Entry(10,60.02f));
        entries.add(new Entry(11,57.57f));
        entries.add(new Entry(12,59.93f));
        entries.add(new Entry(13,53.46f));
        entries.add(new Entry(14,56.50f));
        entries.add(new Entry(15,53.52f));
        entries.add(new Entry(16,66.92f));
        entries.add(new Entry(17,64.01f));

        LineDataSet lineDataSet = new LineDataSet(entries, "Sea level");
        lineDataSet.setColor(Color.RED);

        LineData lineData = new LineData(lineDataSet);

        lineChart.setData(lineData);

        lineChart.invalidate();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
}