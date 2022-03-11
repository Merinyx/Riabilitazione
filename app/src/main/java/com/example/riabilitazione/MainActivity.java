package com.example.riabilitazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    public Button areapersona, allenamentopersona, progressopersona;



    public void areapersonalelaunch(){
        areapersona = (Button) findViewById(R.id.areapersonale);
        areapersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(MainActivity.this, informazionipersonali.class);
                startActivity(ap);
            }
        });

    }

    public void allenamentolaunch(){
        allenamentopersona = (Button) findViewById(R.id.workoutgiorno);
        allenamentopersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allena = new Intent(MainActivity.this, AllenamentoPaziente.class);

                startActivity(allena);
            }
        });

    }

    public void progressoLaunch(){
        progressopersona = (Button) findViewById(R.id.progressopersona);
        progressopersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent progresso = new Intent(MainActivity.this, ProgressoPaziente.class);
                startActivity(progresso);
            }
        });

    }
    public void dettagliLaunch(){
        progressopersona = (Button) findViewById(R.id.dettagliese);
        progressopersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dettagli = new Intent(MainActivity.this, DettagliAllenamento.class);
                startActivity(dettagli);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegistroPaziente newPatient = new RegistroPaziente("Mersiha", "Fazlic",
                "11/02/1995", "FZLMSH95", 10,
                "Terapia riablititativa per la postura del corpo di una durata di");

        areapersonalelaunch();
        allenamentolaunch();
        progressoLaunch();
        dettagliLaunch();

    }
}