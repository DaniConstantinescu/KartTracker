package com.example.fx;

import java.time.LocalDate;
import java.util.Date;

public class Cheltuieli {

    String tip;
    String descriere;
    float pret;
    LocalDate data;

    public Cheltuieli(String tip, String descriere, float pret, LocalDate data) {
        this.tip = tip;
        this.descriere = descriere;
        this.pret = pret;
        this.data = data;
    }


    @Override
    public String toString() {
        return "Cheltuieli{" +
                "tip='" + tip + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                ", data=" + data +
                '}';
    }

    /**
     *
     * Getters and setters
     */
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
