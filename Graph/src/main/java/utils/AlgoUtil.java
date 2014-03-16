package utils;

import java.util.Random;

/**
 * Created by usman on 23/02/2014.
 */
public class AlgoUtil {

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
            int j = i + random.nextInt(a.length - i);
            exchange(a, i, j);
        }
    }

    public static int rank(Comparable[] a, Comparable key) {
        int low = 0;
        int high = a.length - 1;

        if (a[low].compareTo(key) == 0) {
            return low;
        }
        if (a[high].compareTo(key) == 0) {
            return high;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = key.compareTo(a[mid]);
            if (compare < 0) {
                high = mid - 1;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }


    public enum Distribution {
        INCREASING {
            @Override
            public Integer[] create(int length) {
                Integer[] result = new Integer[length];
                for (int i = 0; i < length; i++) {
                    result[i] = i;
                }
                return result;
            }
        },
        DECREASING {
            @Override
            public Integer[] create(int length) {
                Integer[] result = new Integer[length];
                for (int i = 0; i < length; i++) {
                    result[i] = length - i - 1;
                }
                return result;
            }
        },
        SAWTOOTH {
            @Override
            public Integer[] create(int length) {
                Integer[] result = new Integer[length];
                for (int i = 0; i < length; i = i + 4) {
                    result[i] = 1;
                    result[i + 1] = 2;
                    result[i + 2] = 3;
                    result[i + 3] = 4;

                }
                return result;
            }
        }, RANDOM {
            @Override
            public Integer[] create(int length) {
                Integer result[] = new Integer[length];
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    result[i] = random.nextInt(10);
                }
                return result;
            }
        };

        public abstract Integer[] create(int length);

    }


}
