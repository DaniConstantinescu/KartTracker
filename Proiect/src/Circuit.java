public class Circuit {

    String nume;
    Lap bestLap, personalBest;
    String tara;
    int corners, lungime;

    public Circuit(String nume, Lap bestLap, Lap personalBest, String tara, int corners, int lungime) {
        this.nume = nume;
        this.bestLap = bestLap;
        this.personalBest = personalBest;
        this.tara = tara;
        this.corners = corners;
        this.lungime = lungime;
    }


    @Override
    public String toString() {
        return "Circuit{" +
                "nume='" + nume + '\'' +
                ", bestLap=" + bestLap +
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

    public Lap getBestLap() {
        return bestLap;
    }

    public void setBestLap(Lap bestLap) {
        this.bestLap = bestLap;
    }

    public Lap getPersonalBest() {
        return personalBest;
    }

    public void setPersonalBest(Lap personalBest) {
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
