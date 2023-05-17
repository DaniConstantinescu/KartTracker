import java.util.Date;

public class Cursa {

    int id;
    Lap bestLap;
    int startPos, finishPos;
    int pits, laps;
    Date data;

    public Cursa(int id, Lap bestLap, int startPos, int finishPos, int pits, int laps, Date data) {
        this.id = id;
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

    public Lap getBestLap() {
        return bestLap;
    }

    public void setBestLap(Lap bestLap) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
