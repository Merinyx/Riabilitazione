package com.example.riabilitazione;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

public class ProgressoPaziente extends AppCompatActivity {
     Button indietrox;
    Appdatamanager singletonProgress = Appdatamanager.getInstance(getApplicationContext());

    public void tornaIndietroLaunch(){
        indietrox = (Button) findViewById(R.id.menuprincipale3);
        indietrox.setText("Indietro");
        indietrox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apfx = new Intent(ProgressoPaziente.this, MainActivity.class);
                startActivity(apfx);
            }
        });

    }
    public DataPoint[] data(){
        int x=singletonProgress.getCountDays();
        double[] y=singletonProgress.getRatingDifficulty();
        DataPoint[] values = new DataPoint[singletonProgress.getCountDays()+1];
        for (int i = 0; i <= x; i++) {
        DataPoint v = new DataPoint(i, y[i]);
        values[i] = v;
         }
        return values;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresso_paziente);

        GraphView grafico;
        grafico = (GraphView) findViewById(R.id.visitagrafica);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data());
        PointsGraphSeries<DataPoint> seriesP = new PointsGraphSeries<>(data());
        grafico.addSeries(series);
        grafico.addSeries(seriesP);
        grafico.getGridLabelRenderer().setVerticalAxisTitle("Difficoltà dell'allenamento");
        grafico.getGridLabelRenderer().setHorizontalAxisTitle("Durata della terapia");
        grafico.getGridLabelRenderer().setGridColor(Color.rgb(195, 177, 225));
        series.setColor(Color.rgb(218, 112, 214));
        seriesP.setColor(Color.rgb(128, 0, 128));
        grafico.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX){
                if(isValueX){
                    return "Day"+super.formatLabel(value, isValueX);
                }
                return super.formatLabel(value, isValueX);
            }
        });
        seriesP.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                String msg = "Giorno terapia: " + Math.round(dataPoint.getX()) + "\n Difficoltà: " + dataPoint.getY();
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
        grafico.getViewport().setXAxisBoundsManual(true);
        grafico.getViewport().setYAxisBoundsManual(true);
        grafico.getViewport().setMinX(1);
        grafico.getViewport().setMaxX(RegistroPaziente.getDurationterapy());
        grafico.getViewport().setMaxY(5);
        grafico.getViewport().setMinY(0);
        double[] arrayvotazione = singletonProgress.getRatingDifficulty();
        TextView descrizione = (TextView) findViewById(R.id.desprogresso);
        descrizione.setText("La durata totale di terapia è di "+ RegistroPaziente.getDurationterapy()+".\nIl paziente ha attualmente svolto " +
                +singletonProgress.getCountDays()+" allenamenti rispetto alla durata totale.\nLa difficoltà dell'ultimo allenamento svolto è votata "
        + arrayvotazione[singletonProgress.getCountDays()]+" su 5.\n");
        tornaIndietroLaunch();
    }
}