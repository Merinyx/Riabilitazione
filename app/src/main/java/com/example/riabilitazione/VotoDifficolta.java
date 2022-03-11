package com.example.riabilitazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class VotoDifficolta extends AppCompatActivity {

    public Button indietro;
    public static double ratingAllenamento;
    Appdatamanager classesingleton = Appdatamanager.getInstance(getApplicationContext());


    public void fineLaunch() {
        indietro = (Button) findViewById(R.id.menuprincipale1);
        indietro.setText("Fine");

        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apf = new Intent(VotoDifficolta.this, MainActivity.class);
                ratingAllenamento = ratingBar.getRating();

                classesingleton.setRatingDifficulty(ratingAllenamento, classesingleton.getCountDays());

                startActivity(apf);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voto_difficolta);
        TextView descrizione = (TextView) findViewById(R.id.votodiffi);
        descrizione.setText("Vota la difficoltà del tuo allenamento");

        if (classesingleton.getCountDays()>RegistroPaziente.getDurationterapy()){
            classesingleton.setCountDays(1);
        }
        fineLaunch();

    }


}