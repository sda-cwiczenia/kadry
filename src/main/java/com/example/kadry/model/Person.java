package com.example.kadry.model;

import org.hibernate.validator.constraints.pl.PESEL;

public class Person {
    private String imie;
    private String nazwisko;
    private int wiek;
    @PESEL
    private String pesel;

    public Person(String imie, String nazwisko, int wiek, @PESEL String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
