package sort;

import java.util.Random;

/**
 * Created by usman on 23/02/2014.
 */
public class SortingUtil {

    public static void print(Object[] toPrint) {
        for (int i = 0; i < toPrint.length; i++) {
            System.out.println("toPrint = " + toPrint[i].toString());
        }
    }

    public static void exchange(Object a[], int from, int to) {
        Object temp = a[from];
        a[from] = a[to];
        a[to] = temp;
    }

    /**
     * comparison utility method
     *
     * @param a
     * @param b
     * @return true if a<b , false otherwise
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    public static void shuffle(Object a[]) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = i + random.nextInt() * (a.length - i);
            exchange(a, i, j);
        }
    }


}
