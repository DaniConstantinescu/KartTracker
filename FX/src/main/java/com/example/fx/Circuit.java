package com.example.fx;

public class Circuit {

    int id;
    String nume;
    Timp bestTimp, personalBest;
    String tara;
    int corners, lungime;


    public Circuit(int id,String nume, Timp bestTimp, Timp personalBest, String tara, int corners, int lungime) {
        this.id = id;
        this.nume = nume;
        this.bestTimp = bestTimp;
        this.personalBest = personalBest;
        this.tara = tara;
        this.corners = corners;
        this.lungime = lungime;
    }
    public Circuit(String nume, Timp bestTimp, Timp personalBest, String tara, int corners, int lungime) {
        this.nume = nume;
        this.bestTimp = bestTimp;
        this.personalBest = personalBest;
        this.tara = tara;
        this.corners = corners;
        this.lungime = lungime;
    }


    @Override
    public String toString() {
        return "Circuit{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", bestTimp=" + bestTimp +
                ", personalBest=" + personalBest +
                ", tara='" + tara + '\'' +
                ", corners=" + corners +
                ", lungime=" + lungime +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Timp getBestTimp() {
        return bestTimp;
    }

    public void setBestTimp(Timp bestTimp) {
        this.bestTimp = bestTimp;
    }

    public Timp getPersonalBest() {
        return personalBest;
    }

    public void setPersonalBest(Timp personalBest) {
        this.personalBest = personalBest;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public int getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }
}
