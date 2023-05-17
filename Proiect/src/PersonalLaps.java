import java.time.LocalDate;
import java.util.List;

public class PersonalLaps {

    int id;
    Lap timp;

    public PersonalLaps(int id, Lap timp ) {
        this.id = id;
        this.timp = timp;
    }


    static int calculateDelta(Lap l){
        return Timp.convertTimpToMs( l.getOverallBest() ) - Timp.convertTimpToMs( l.getTimp() );
    }

    static int calculateDelta(List<Lap> lista){

        int s = (int)lista
                .stream()
                .mapToInt( i -> calculateDelta(i) )
                .average().getAsDouble();
        return s;
    }

    static int calculateDelta(List<Lap> lista, LocalDate dataAleasa){

        int s = (int) lista
                .stream()
                .filter( f -> f.data.toLocalDate().equals(dataAleasa) )
                .mapToInt( i -> calculateDelta(i) )
                .average().getAsDouble();
        return s;
    }

    @Override
    public String toString() {
        return "PersonalLaps{" +
                "id=" + id +
                ", timp=" + timp +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lap getTimp() {
        return timp;
    }

    public void setTimp(Lap timp) {
        this.timp = timp;
    }


}
