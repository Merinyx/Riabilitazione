package com.example.riabilitazione;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppdatamanagerSavedInsta {

    public static final String PREF_NAME = "app_settings";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor = preferences.edit();
    ArrayList<String> arrPackage = new ArrayList<>();


    public AppdatamanagerSavedInsta(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public AppdatamanagerSavedInsta() {

    }

    //String Values
    public void setStringValue(String instanceName, String token)
    {
        editor.putString(instanceName, token);
        editor.apply();
    }

    public String getStringValue(String instanceName)
    {
        return preferences.getString(instanceName, "");
    }
  //Int values
    public void setIntValue(String instanceName, int token)
    {
        editor.putInt(instanceName, token);
        editor.apply();
    }

    public int getIntValue(String instanceName)
    {
        return preferences.getInt(instanceName, 0);
    }
    //double values
    public void setDoubleValue(String instanceName, double token)
    {
        editor.putFloat(instanceName, (float) token);
        editor.apply();
    }

    public double getDoubleValue(String instanceName)
    {
        return preferences.getFloat(instanceName, 0);
    }

    //arrays
    private void setListofArray(String token, double[] listaArray) {
        String s = Arrays.toString(listaArray);
        s = s.substring(1, s.length()- 1);
        String[] arrLista = s.split(", ");

        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(arrLista));
        editor.putStringSet(token, set);
        editor.apply();
        Log.d("storesharedPreferences",""+set);
    }

    private void getListofArray(String token) {
        Set<String> set = preferences.getStringSet(token, null);
        arrPackage.addAll(set);
        String[] listaString = arrPackage.toArray(new String[0]);
        double[] doubleArray = Arrays.stream(listaString).mapToDouble(Double::parseDouble).toArray();
        Log.d("retrivesharedPreferences",""+set);
    }

}
