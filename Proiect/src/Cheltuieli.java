import java.util.Date;

public class Cheltuieli {

    String tip;
    String descriere;
    float pret;
    Date data;

    public Cheltuieli(String tip, String descriere, float pret, Date data) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
