package com.example.traveler.przemek1;


/**
 * Created by User on 3/14/2017.
 */

public class Wiersz12 {
    private String lewy;
    private String prawygora;
    private String prawydol;
    private String dodatkowy;

    public Wiersz12(String name, String birthday, String sex) {
        this.prawygora = prawygora;
        this.lewy = lewy;
        this.prawydol = prawydol;
    }

    public String getPrawyGora() {
        return prawygora;
    }

    public void setPrawyGora(String identyfikator) {
        this.prawygora = identyfikator;
    }

    public String getLewy() {
        return lewy;
    }

    public void setLewy(String lewy) {
        this.lewy = lewy;
    }

    public String getPrawyDol() {
        return prawydol;
    }

    public void setPrawyDol(String rejestracja) {
        this.prawydol = rejestracja;
    }

    public String getDodatkowy() {
        return dodatkowy;
    }

    public void setDodatkowy(String identyfikator) {
        this.dodatkowy = identyfikator;
    }
}