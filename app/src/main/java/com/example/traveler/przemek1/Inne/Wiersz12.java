package com.example.traveler.przemek1.Inne;


/**
 * Created by User on 3/14/2017.
 */

public class Wiersz12 {
    private String lewy;
    private String prawygora;
    private String prawydol;
    private String lewydol;
    private String lewygora;
    private String dodatkowy;
    private String dodatkowy2;

    public Wiersz12(String lewy, String prawygora, String prawydol) {
        this.prawygora = prawygora;
        this.lewy = lewy;
        this.prawydol = prawydol;
    }

    public Wiersz12(String lewydol, String lewygora, String prawygora, String prawydol) {
        this.prawygora = prawygora;
        this.lewygora = lewygora;
        this.lewydol = lewydol;
        this.prawydol= prawydol;
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

    public String getLewydol() {
        return lewydol;
    }

    public void setLewydol(String lewydol) {
        this.lewydol = lewydol;
    }

    public String getLewygora() {
        return lewygora;
    }

    public void setLewygora(String lewygora) {
        this.lewygora = lewygora;
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

    public String getDodatkowy2() {
        return dodatkowy2;
    }

    public void setDodatkowy2(String dodatkowy2) {
        this.dodatkowy2 = dodatkowy2;
    }
}