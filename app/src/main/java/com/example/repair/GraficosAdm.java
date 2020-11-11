package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.model.SliceValue;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class GraficosAdm extends AppCompatActivity
{


    PieChartView pieChartView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos_adm);


        PieChartView pieChartView = findViewById(R.id.chart);

        pieChartView = findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("DS"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("Nutri"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("ELO"));
        pieData.add(new SliceValue(60, Color.MAGENTA).setLabel("Geral"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Chamados").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#808080"));
        pieChartView.setPieChartData(pieChartData);







    }
}
