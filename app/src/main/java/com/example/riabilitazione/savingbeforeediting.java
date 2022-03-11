package com.example.riabilitazione;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class savingbeforeediting {
    private final double[] votodifficolta = new double[100];
    private final double[] votoDolore=new double[100]; private int[] esercizidafare;
    int contaGiorni=0; int contaEsercizi=0;

    //variabili per shared instances
    public static final String PREF_NAME = "app_settings";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor = preferences.edit();
    ArrayList<String> arrPackage = new ArrayList<>();

    //definizione delle funzioni necessarie per le altre attività della app

    //un contatore generale per gli esercizi che si fanno durante un allenamento
    public int getContaEsercizi() {
        return preferences.getInt("contaEsercizi", 0);
    }

    public void setContaEsercizi(int contaEsercizi) {
        if (contaEsercizi==0) this.contaEsercizi++;
        if (contaEsercizi==1) this.contaEsercizi=0;
        editor.putInt("contaEsercizi", contaEsercizi);
        editor.commit();
    }

    //definisco una funzione che richiama la votazione della attività VotoDifficolta e le memorizzo in un array
    public void setVotodifficolta(double votoinserito, int contatore){
        this.votodifficolta[contatore] = votoinserito;
        String s = Arrays.toString(votodifficolta);
        s = s.substring(1, s.length()- 1);
        String[] arrLista = s.split(", ");
        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(arrLista));
        editor.putStringSet("listaVotoDifficolta", set);
        editor.commit();
    }

    public double[] getVotodifficolta() {
        Set<String> set = preferences.getStringSet("listaVotoDifficolta", null);
        arrPackage.addAll(set);
        String[] listaString = arrPackage.toArray(new String[0]);
        double[] doubleArray = Arrays.stream(listaString).mapToDouble(Double::parseDouble).toArray();
        return doubleArray;
    }

    //definizione di una funzione che implementa un contantore del giorno di allenamento
    public void setContaGiorni(int i){
        if (i==0) this.contaGiorni++;
        if (i==1) this.contaGiorni=0;
        editor.putInt("contaGiorni", contaGiorni);
        editor.commit();
    }

    public int getContaGiorni() {
        return preferences.getInt("contaGiorni", 0);
    }

    //definizione di una funzione per l'esercizio giornaliero che fa vedere al paziente gli esercizi che deve fare in un
    //definito giorno

    //
    public int[] getEsercizidafare(int giorno) {

        switch (giorno){
            case 1: esercizidafare = new int[]{0, 4, 6, 8, 5};
                break;
            case 2: esercizidafare = new int[]{1,3,6,7,8};
                break;
            case 3: esercizidafare = new int[]{2,4,6,7,8};
                break;
            case 4: esercizidafare = new int[]{1,3,5,7,8};
                break;
            case 5: esercizidafare = new int[]{0,2,3,4,5};
                break;
            case 6: esercizidafare = new int[]{1,4,6,7,8};
                break;
            case 7: esercizidafare = new int[]{0,3,5,7,8};
                break;
            case 8: esercizidafare = new int[]{1,3,4,7,8};
                break;
            case 9: esercizidafare = new int[]{2,3,5,6,7};
                break;
            case 10: esercizidafare = new int[]{0,3,4,6,7};
                break;
            default:esercizidafare = new int[]{1,2,3,4,5};
                break;
        }
        return esercizidafare;
    }

//funzione che salva i rating del dolore di vari esercizi e li salva in un array per un progresso personalizzato


    public double[] getVotoDolore() {
        return votoDolore;
    }

    public void setVotoDolore(double votoDoloreEs, int i) {
        this.votoDolore[i] = votoDoloreEs;
    }
}
