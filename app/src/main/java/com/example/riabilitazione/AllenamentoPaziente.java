package com.example.riabilitazione;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.io.FileNotFoundException;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AllenamentoPaziente extends AppCompatActivity {
    Button next, finish; int i = 0; int esercizi = 8;
    Appdatamanager singletonAllenamento = Appdatamanager.getInstance(AllenamentoPaziente.this);


    public void nextLaunch(){
        next = (Button) findViewById(R.id.prossimo);
        final RatingBar votoDolore = (RatingBar) findViewById(R.id.livellodolore);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(AllenamentoPaziente.this, AllenamentoPaziente.class);
                singletonAllenamento.setRatingPain(votoDolore.getRating(), singletonAllenamento.getCountExercises());

                startActivity(ap);
            }
        });

    }

    public void fineLaunch(){
        finish = (Button) findViewById(R.id.prossimo);
        finish.setText("Fine");
        final RatingBar votoDolore = (RatingBar) findViewById(R.id.livellodolore);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apf = new Intent(AllenamentoPaziente.this, VotoDifficolta.class);
                singletonAllenamento.setRatingPain(votoDolore.getRating(), singletonAllenamento.getCountExercises());
                startActivity(apf);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allenamento_paziente);
        int immagine;
        int[] fiveRandomNumbers = new int[0];

            fiveRandomNumbers = singletonAllenamento.getTodoExercises(singletonAllenamento.getCountDays());


        ImageView immagineEs = (ImageView) findViewById(R.id.immagineAllenamento);
        int exercise = fiveRandomNumbers[singletonAllenamento.getCountExercises()];
        switch (exercise){
            case 0: immagine =R.drawable.es1;
                break;
            case 1: immagine =R.drawable.es2;
                 break;
            case 2: immagine =R.drawable.es3;
                break;
            case 3: immagine =R.drawable.es4;
                break;
            case 4: immagine =R.drawable.es5;
                break;
            case 5: immagine =R.drawable.es6;
                break;
            case 6: immagine =R.drawable.es7;
                break;
            case 7: immagine =R.drawable.es8;
                break;
            case 8: immagine =R.drawable.es9;
                break;
            default: immagine = R.drawable.es1;
        }
        immagineEs.setImageResource(immagine);

        singletonAllenamento.setCountExercises(0);
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // inizializzo chronometro
        simpleChronometer.start(); // start a chronometer

        if(singletonAllenamento.getCountExercises()<=4){
            nextLaunch();
        }else {
            singletonAllenamento.setCountExercises(1);
            singletonAllenamento.setCountDays(0);
            fineLaunch();
        }

    }
}