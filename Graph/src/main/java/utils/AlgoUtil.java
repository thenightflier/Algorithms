package utils;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

import java.util.Random;
import java.util.Set;

/**
 * Created by usman on 23/02/2014.
 */
public class AlgoUtil {

    public static void print(Object[] toPrint) {
        for (int i = 0; i < toPrint.length; i++) {
            System.out.println("toPrint = " + toPrint[i].toString());
        }
    }

    public static long sum(int[] a) {
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result + a[i];
        }
        return result;
    }

    public static long sumToN(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }


    public static void exchange(Object a[], int from, int to) {
        Object temp = a[from];
        a[from] = a[to];
        a[to] = temp;
    }

    public static int[] convert(Integer[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i];
        }
        return result;
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

    public static void print(int[] solution) {
        System.out.println(Ints.asList(solution));
    }


    public enum Distribution {
        INCREASING {
            @Override
            public Integer[] create(int length, int multiplier) {
                Integer[] result = new Integer[length];
                for (int i = 0; i < length; i++) {
                    result[i] = i * multiplier;
                }
                return result;
            }
        },
        DECREASING {
            @Override
            public Integer[] create(int length, int multiplier) {
                Integer[] result = new Integer[length];
                for (int i = 0; i < length; i++) {
                    result[i] = (length - i - 1) * multiplier;
                }
                return result;
            }
        },
        SAWTOOTH {
            @Override
            public Integer[] create(int length, int multiplier) {
                Integer[] result = new Integer[length];
                for (int i = 0; i < length; i = i + 5) {
                    result[i] = 1 * multiplier;
                    result[i + 1] = 2 * multiplier;
                    result[i + 2] = 3 * multiplier;
                    result[i + 3] = 4 * multiplier;
                    result[i + 4] = 5 * multiplier;

                }
                return result;
            }
        }, RANDOM {
            @Override
            public Integer[] create(int length, int multiplier) {
                Integer result[] = new Integer[length];
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    result[i] = random.nextInt(length) * multiplier;
                }
                return result;
            }
        }, MISSING_NUMBER {
            @Override
            public Integer[] create(int length, int multiplier) {
                Random random = new Random();
                Set<Integer> uniqueEntries = Sets.newHashSet();
                uniqueEntries.add(0);
                Integer[] result = new Integer[length];
                result[0] = 1;
                uniqueEntries.add(1);
                if (length > 1) {
                    result[1] = length + 1;
                    uniqueEntries.add(length + 1);
                }
                for (int i = 2; i < length; i++) {
                    int temp = random.nextInt(length + 1);
                    while (uniqueEntries.contains(temp)) {
                        temp = random.nextInt(length + 1);
                    }
                    result[i] = temp;
                    uniqueEntries.add(temp);

                }
                return result;
            }
        }, PERM_CHECK {
            @Override
            public Integer[] create(int length, int multiplier) {
                Random random = new Random();
                Set<Integer> uniqueEntries = Sets.newHashSet();
                uniqueEntries.add(0);
                Integer[] result = new Integer[length];
                for (int i = 1; i < length; i++) {
                    int temp = random.nextInt(length + 1);
                    while (uniqueEntries.contains(temp)) {
                        temp = random.nextInt(length + 1);
                    }
                    result[i] = temp;
                    uniqueEntries.add(temp);

                }
                return result;
            }
        };

        public abstract Integer[] create(int length, int multiplier);

    }


}
