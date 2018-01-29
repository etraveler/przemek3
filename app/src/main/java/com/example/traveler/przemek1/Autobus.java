package com.example.traveler.przemek1;


/**
 * Created by User on 3/14/2017.
 */

public class Autobus {
    private String marka;
    private String identyfikator;
    private String rejestracja;

    public Autobus(String name, String birthday, String sex) {
        this.identyfikator = identyfikator;
        this.marka = marka;
        this.rejestracja = rejestracja;
    }

    public String getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(String identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRejestracja() {
        return rejestracja;
    }

    public void setRejestracja(String rejestracja) {
        this.rejestracja = rejestracja;
    }
}