package com.example.riabilitazione;

public class RegistroPaziente {
    public static String name, surname, dateofbirth, patientid;
    public static int durationterapy;
    public static String descriptionterapy;

    public RegistroPaziente(String nome, String cognome, String datadinascita, String codicepaziente,
                            int durataterapia, String descrizioneterapia) {
        this.name = nome;
        this.surname = cognome;
        this.dateofbirth = datadinascita;
        this.patientid = codicepaziente;
        this.durationterapy = durataterapia;
        this.descriptionterapy = descrizioneterapia;
    }


    public void setName(String nome) { this.name = nome; }

    public static String getName(){
        return name;
    }

    public static String getSurname() { return surname; }

    public void setSurname(String cognome) {
        this.surname = cognome;
    }

    public static String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String datadinascita) {
        this.dateofbirth = datadinascita;
    }

    public static String getPatientid() {
        return patientid;
    }

    public void setPatientid(String codicepaziente) {
        this.patientid = codicepaziente;
    }

    public static int getDurationterapy() {
        return durationterapy;
    }

    public void setDurationterapy(int durataterapia) {
        this.durationterapy = durataterapia;
    }


    public static String getDescriptionterapy() {
        return descriptionterapy;
    }

    public void setDescriptionterapy(String descrizioneterapia) { this.descriptionterapy = descrizioneterapia; }
}
