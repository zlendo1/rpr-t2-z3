package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        System.out.print( "Unesite vrijednosti: " );

        List<Double> lista = new ArrayList<>();

        while (true) {
            Scanner unos = new Scanner( System.in );

            if ( unos.nextLine().compareTo( "stop" ) == 0 ) {
                break;
            }

            try {
                lista.add( unos.nextDouble() );
            } catch ( Exception ignored ) {}
        }

        if ( lista.isEmpty() ) {
            return;
        }

        double min = lista.get( 0 ), max = lista.get( 0 ), mean = 0d, standard_deviation = 0d;

        for ( double x : lista ) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            mean += x;
        }

        mean /= lista.size();

        for ( double x : lista ) {
            standard_deviation += Math.pow( x - mean, 2 );
        }

        standard_deviation = Math.sqrt( mean / lista.size() );

        System.out.printf( "Min: %.3g Max: %.3f Srednja vrijednost: %.3f Stardnandna devijacija: %.3f",
                min, max, mean, standard_deviation);
    }
}
