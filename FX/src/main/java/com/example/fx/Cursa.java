package com.example.fx;

import java.time.LocalDate;
import java.util.Date;

public class Cursa {

    int id, idCircuit;
    Timp bestLap;
    int startPos, finishPos;
    int pits, laps;
    LocalDate data;

    public Cursa(int id, int idCircuit, Timp bestLap, int startPos, int finishPos, int pits, int laps, LocalDate data) {
        this.id = id;
        this.idCircuit = idCircuit;
        this.bestLap = bestLap;
        this.startPos = startPos;
        this.finishPos = finishPos;
        this.pits = pits;
        this.laps = laps;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", idCircuit=" + idCircuit +
                ", bestLap=" + bestLap +
                ", startPos=" + startPos +
                ", finishPos=" + finishPos +
                ", pits=" + pits +
                ", laps=" + laps +
                ", data=" + data +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCircuit() {
        return idCircuit;
    }

    public void setIdCircuit(int idCircuit) {
        this.idCircuit = idCircuit;
    }

    public Timp getBestLap() {
        return bestLap;
    }

    public void setBestLap(Timp bestLap) {
        this.bestLap = bestLap;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getFinishPos() {
        return finishPos;
    }

    public void setFinishPos(int finishPos) {
        this.finishPos = finishPos;
    }

    public int getPits() {
        return pits;
    }

    public void setPits(int pits) {
        this.pits = pits;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
