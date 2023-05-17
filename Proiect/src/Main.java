import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {




    public static void main(String[] args) {


        List<Lap> test = Arrays.asList( new Lap("",new Timp(1,23,14),27302,1000000,10000000, new Timp(0,0,0), LocalDateTime.now()),
                new Lap("", new Timp(30000,27413,27326), 30000, 27413, 27326, new Timp(0,0,0), LocalDateTime.now() ));

        /*testare gasire Best Lap
        Timp bst = Lap.bestLap(test);
        System.out.println(bst.toString());
        */

        /* testare calculare Ideal Lap
        System.out.println( Lap.idelLap(test,"") );
         */


        Lap testLap = new Lap("",new Timp(1,23,14),27302,1000000,10000000, new Timp(1,23,12), LocalDateTime.now());

        System.out.println( PersonalLaps.calculateDelta(testLap) );

    }
}