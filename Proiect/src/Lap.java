import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lap {

    String numeCircuit;
    Timp timp;
    int s1;
    int s2;
    int s3;
    Timp overallBest;
    LocalDateTime data;

    public Lap(){};
    public Lap(String numeCircuit, Timp timp, int s1, int s2, int s3, Timp overallBest, LocalDateTime data) {
        this.numeCircuit = numeCircuit;
        this.timp = timp;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.overallBest = overallBest;
        this.data = data;
    }


    /**
     * gasirea celui mai bun timp
     * @param lista lista cu timpi existenti
     * @return timplu cel mai bun din lista data
     */
    static Timp bestLap(List<Lap> lista){

        Lap l = lista
                .stream()
                .max( (l1,l2) -> {
                    //comparare minute
                    if ( l1.getTimp().getMinute() > l2.getTimp().getMinute() )
                        return -1;
                    else if (l1.getTimp().getMinute() < l2.getTimp().getMinute()) {
                        return 1;
                    }

                    //comparare secunde
                    if ( l1.getTimp().getSecunde() > l2.getTimp().getSecunde() )
                        return -1;
                    else if (l1.getTimp().getSecunde() < l2.getTimp().getSecunde()) {
                        return 1;
                    }

                    //compara milisec
                    if ( l1.getTimp().getMilisecunde() > l2.getTimp().getMilisecunde() )
                        return -1;
                    else if (l1.getTimp().getMilisecunde() < l2.getTimp().getMilisecunde()) {
                        return 1;
                    }

                    return 0;
                }).get();

        return l.timp;
    }

    /**
     * gasirea celui mai bun timp pe un circuit dat
     * @param lista lista cu timpi existenti
     * @param circuit numele circuitului
     * @return timplu cel mai bun din lista data pentru circuitul ales
     */
    static Timp bestLap(List<Lap> lista,String circuit){

        Lap l = lista
                .stream()
                .filter( f -> f.numeCircuit.equals(circuit) )
                .max( (l1,l2) -> {
                    //comparare minute
                    if ( l1.getTimp().getMinute() > l2.getTimp().getMinute() )
                        return -1;
                    else if (l1.getTimp().getMinute() < l2.getTimp().getMinute()) {
                        return 1;
                    }

                    //comparare secunde
                    if ( l1.getTimp().getSecunde() > l2.getTimp().getSecunde() )
                        return -1;
                    else if (l1.getTimp().getSecunde() < l2.getTimp().getSecunde()) {
                        return 1;
                    }

                    //compara milisec
                    if ( l1.getTimp().getMilisecunde() > l2.getTimp().getMilisecunde() )
                        return -1;
                    else if (l1.getTimp().getMilisecunde() < l2.getTimp().getMilisecunde()) {
                        return 1;
                    }

                    return 0;
                }).get();

        return l.timp;
    }

    /**
     * gasirea celui mai bun timp dintr-o zi
     * @param lista lista cu timpi existenti
     * @param dataAleasa data pentru care se vrea aflarea celui mai bun timp
     * @return timplu cel mai bun din lista data pentru circuitul ales
     */
    static Timp bestLap(List<Lap> lista, Date dataAleasa){

        Lap l = lista
                .stream()
                .filter( f -> f.data.toLocalDate().equals(dataAleasa) )
                .max( (l1,l2) -> {
                    //comparare minute
                    if ( l1.getTimp().getMinute() > l2.getTimp().getMinute() )
                        return -1;
                    else if (l1.getTimp().getMinute() < l2.getTimp().getMinute()) {
                        return 1;
                    }

                    //comparare secunde
                    if ( l1.getTimp().getSecunde() > l2.getTimp().getSecunde() )
                        return -1;
                    else if (l1.getTimp().getSecunde() < l2.getTimp().getSecunde()) {
                        return 1;
                    }

                    //compara milisec
                    if ( l1.getTimp().getMilisecunde() > l2.getTimp().getMilisecunde() )
                        return -1;
                    else if (l1.getTimp().getMilisecunde() < l2.getTimp().getMilisecunde()) {
                        return 1;
                    }

                    return 0;
                }).get();

        return l.timp;
    }

    /**
     * Calcularea unui tur ideal
     * @param lista lista de timpi existenti
     * @param circuit numele circuitului pt care sa se calculere
     * @return timpul ideal
     */
    static Timp idelLap(List<Lap> lista, String circuit){

        int s1 = lista
                .stream()
                .filter( f -> f.numeCircuit.equals(circuit) )
                .min( Comparator.comparing(Lap::getS1) ).get().getS1();

        int s2 = lista
                .stream()
                .filter( f -> f.numeCircuit.equals(circuit) )
                .min( Comparator.comparing(Lap::getS2) ).get().getS2();

        int s3 = lista
                .stream()
                .filter( f -> f.numeCircuit.equals(circuit) )
                .min( Comparator.comparing(Lap::getS3) ).get().getS3();

        return Timp.convertMs(s1+s2+s3);
    }

    @Override
    public String toString() {
        return "Lap{" +
                "numeCircuit='" + numeCircuit + '\'' +
                ", timp=" + timp +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", overallBest=" + overallBest +
                '}';
    }

    /* GETTERS & SETTERS */

    public String getNumeCircuit() {
        return numeCircuit;
    }

    public void setNumeCircuit(String numeCircuit) {
        this.numeCircuit = numeCircuit;
    }
    public Timp getTimp() {
        return timp;
    }

    public void setTimp(Timp timp) {
        this.timp = timp;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getS3() {
        return s3;
    }

    public void setS3(int s3) {
        this.s3 = s3;
    }

    public Timp getOverallBest() {
        return overallBest;
    }

    public void setOverallBest(Timp overallBest) {
        this.overallBest = overallBest;
    }

}

class Timp {

    int minute, secunde,milisecunde;

    public Timp() {
    }

    public Timp(int minute, int secunte, int milisecunde) {
        this.minute = minute;
        this.secunde = secunte;
        this.milisecunde = milisecunde;
    }
    public Timp(int ms){

        int minute =  (int)TimeUnit.MILLISECONDS.toMinutes(ms);
        ms = ms - minute * 60 *1000;

        int secunde  =  (int)TimeUnit.MILLISECONDS.toSeconds(ms);
        ms = ms - secunde * 1000;

        this.minute = minute;
        this.secunde = secunde;
        this.milisecunde = ms;


    }

    /**
     * Converteste un nr de milisecunde la un timp in formatul mm:ss:ms
     * @param ms numarul de milisecunde
     * @return timpul convertit la format mm:ss:ms
     */
    static Timp convertMs(int ms){

        int minute =  (int)TimeUnit.MILLISECONDS.toMinutes(ms);
        ms = ms - minute * 60 *1000;

        int secunde  =  (int)TimeUnit.MILLISECONDS.toSeconds(ms);
        ms = ms - secunde * 1000;

        return new Timp(minute,secunde,ms);
    }

    /**
     * Convertest un timp in milisecunde
     * @param t timpul care trebuie sa fie convertit la milisecunde
     * @return numarul de milisecunde
     */
    static int convertTimpToMs(Timp t){
        return t.getMilisecunde() + 1000 * t.getSecunde() + 60 * 1000 * t.getMinute();
    }

    @Override
    public String toString() {
        return "Timp{" +
                "minute=" + minute +
                ", secunte=" + secunde +
                ", milisecunde=" + milisecunde +
                '}';
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecunde() {
        return secunde;
    }

    public void setSecunde(int secunde) {
        this.secunde = secunde;
    }

    public int getMilisecunde() {
        return milisecunde;
    }

    public void setMilisecunde(int milisecunde) {
        this.milisecunde = milisecunde;
    }

}

