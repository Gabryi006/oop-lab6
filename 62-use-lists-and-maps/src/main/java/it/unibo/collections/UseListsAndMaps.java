package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    private static final int ELEMS=100000;
    private static final int READS=1000;
    private static final int FIRST=1000;
    private static final int LAST=2000;
    private static final Long AFRICA= 1_110_635_000L;
    private static final Long AMERICA=972_005_000L;
    private static final Long ANT=0L;
    private static final Long ASIA=4_298_723_000L;
    private static final Long OCEANIA=38_304_000L;
    private static final Long EUROPE=742_452_000L;

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> list= new ArrayList<>();

        for(int i=FIRST; i<LAST; i++) {

            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> newList= new LinkedList<Integer>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */


        final var temp=list.getFirst();
        list.set(0, list.getLast());
        list.set(list.size()-1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(var i:list) {

            IO.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();
        for(int i=0; i<ELEMS; i++) {

            list.addFirst(i);
        }

        time= System.nanoTime() -time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);

        IO.println(
            "Inserting" + " " + ELEMS + " " + "ints in a ArrayList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );

        time= System.nanoTime();

        for(int i=0; i<ELEMS; i++) {

            newList.add(i);
        }

        time= System.nanoTime() -time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        IO.println(
            "Inserting" + " " + ELEMS + " " + "ints in a LinkedList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */


        time= System.nanoTime();

        for(int i=0; i<READS; i++) {
            list.get((list.size()/2)-1);
        }

        time=System.nanoTime()-time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        IO.println(
            "Reading" + " " + READS + " " + "times in the middle of the ArrayList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );

        time= System.nanoTime();

        for(int i=0; i<READS; i++) {
            newList.get((newList.size()/2)-1);
        }

        time=System.nanoTime()-time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        IO.println(
            "Reading" + " " + READS + " " + "times in the middle of the LinkedList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );

        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> population = new HashMap<>();

        population.put("Africa", AFRICA);
        population.put("America", AMERICA);
        population.put("Antarctica", ANT);
        population.put("Asia", ASIA);
        population.put("Europe", EUROPE);
        population.put("Oceania", OCEANIA); 

        
        /*
         * 8) Compute the population of the world
         */

        Long tot=0L;
        for ( final Long s : population.values() ) {
           tot=tot+s;
        }

        IO.println("Total computed in map: "+tot);
    }
}
