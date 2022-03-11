package com.example.riabilitazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class informazionipersonali extends AppCompatActivity {

    public Button indietro;

    public void tornaIndietro(){
        indietro = (Button) findViewById(R.id.menuprincipale1);
        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(informazionipersonali.this, MainActivity.class);
                startActivity(ap);
            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informazionipersonali);
        TextView name = (TextView) findViewById(R.id.nomePaziente);
        name.setText(RegistroPaziente.getName());
        TextView surname = (TextView) findViewById(R.id.cognomePaziente);
        surname.setText(RegistroPaziente.getSurname());
        TextView dateofbirth = (TextView) findViewById(R.id.datadinascita);
        dateofbirth.setText(RegistroPaziente.getDateofbirth());
        TextView idpatient = (TextView) findViewById(R.id.idPaziente);
        idpatient.setText("ID PERSONALE: " + RegistroPaziente.getPatientid());
        TextView description = (TextView) findViewById(R.id.descrizioneTerapia);
        description.setText(RegistroPaziente.getDescriptionterapy() + RegistroPaziente.getDurationterapy()+" giorni");
        tornaIndietro();
    }
}