package com.example.riabilitazione;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Appdatamanager extends Application { //classe singleton per la gestione di tutte le activity e variabili della app

    private static volatile Appdatamanager appdatamanager = null;

    public static Appdatamanager getInstance(Context applicationContext) {
        //il doppio controllo sulla creazione di nuovo singleton appdatamanager nel caso piu threads cercano di accedere
        // alla classe insieme, non si creano piu appdatamanager allo stesso tempo ma viene inizializzato solo uno per tutti
        if (appdatamanager == null) {
            synchronized (Appdatamanager.class){        //double check locking in java
                if (appdatamanager == null){
                    appdatamanager = new Appdatamanager(applicationContext); }
            }
        }
        return appdatamanager;
    }

    private Appdatamanager(Context applicationContext) {
        appContext = applicationContext;
        preferences = appContext.getSharedPreferences(appContext.getString(R.string.key_pref), Context.MODE_PRIVATE);
    };


    private final double[] ratingDifficulty = new double[100];
    private final double[] ratingPain=new double[100]; private int[] todoExercises;
    int countDays=0; int countExercises=0; Context context = null;
    //variabili per shared instances;
    private SharedPreferences preferences;
    private Context appContext;

    private SharedPreferences.Editor editor = preferences.edit();
    ArrayList<String> arrPackage = new ArrayList<>();



    //definizione delle funzioni necessarie per le altre attività della app

    //un contatore generale per gli esercizi che si fanno durante un allenamento
    public int getCountExercises() {
        return countExercises;
    }

    public void setCountExercises(int contaEsercizi) {
        if (contaEsercizi==0) this.countExercises++;
        if (contaEsercizi==1) this.countExercises=0;

    }

    //definisco una funzione che richiama la votazione della attività VotoDifficolta e le memorizzo in un array
    public void setRatingDifficulty(double rating, int counter){
        this.ratingDifficulty[counter] = rating;

    }

    public double[] getRatingDifficulty() {
        return ratingDifficulty;
    }

    //definizione di una funzione che implementa un contantore del giorno di allenamento
    public void setCountDays(int i){
        if (i==0) this.countDays++;
        if (i==1) this.countDays=0;

    }

    public int getCountDays() {
        return countDays;
    }

    //definizione di una funzione per l'esercizio giornaliero che fa vedere al paziente gli esercizi che deve fare in un
    //definito giorno

    //
    public int[] getTodoExercises(int giorno) {

        switch (giorno){
            case 1: todoExercises = new int[]{0, 4, 6, 8, 5};
            break;
            case 2: todoExercises = new int[]{1,3,6,7,8};
                break;
            case 3: todoExercises = new int[]{2,4,6,7,8};
                break;
            case 4: todoExercises = new int[]{1,3,5,7,8};
                break;
            case 5: todoExercises = new int[]{0,2,3,4,5};
                break;
            case 6: todoExercises = new int[]{1,4,6,7,8};
                break;
            case 7: todoExercises = new int[]{0,3,5,7,8};
                break;
            case 8: todoExercises = new int[]{1,3,4,7,8};
                break;
            case 9: todoExercises = new int[]{2,3,5,6,7};
                break;
            case 10: todoExercises = new int[]{0,3,4,6,7};
                break;
            default:todoExercises = new int[]{1,2,3,4,5};
            break;
        }
        return todoExercises;
    }

//funzione che salva i rating del dolore di vari esercizi e li salva in un array per un progresso personalizzato


    public double[] getRatingPain() {
        return ratingPain;
    }

    public void setRatingPain(double painrating, int i) {
        this.ratingPain[i] = painrating;
    }
}
