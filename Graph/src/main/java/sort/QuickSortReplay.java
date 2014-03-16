package sort;

import utils.AlgoUtil;

import java.util.Arrays;

import static utils.AlgoUtil.*;

/**
 * Created by usman on 06/03/2014.
 */
public class QuickSortReplay {

    public static void main(String[] args) {
        Integer a[] = AlgoUtil.Distribution.RANDOM.create(10);
        System.out.println(Arrays.asList(a));
        sort(a);
        System.out.println(Arrays.asList(a));

    }

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable a[], int low, int high) {
        if (high <= low) {
            return;
        }

        int partition = partition(a, low, high);

        sort(a, low, partition - 1);
        sort(a, partition + 1, high);

    }

    private static int partition(Comparable[] a, int low, int high) {
        int leftIndex = low;
        int rightIndex = high + 1;
        Comparable key = a[low];
        while (leftIndex <= rightIndex) {
            while (less(a[++leftIndex], key))
                if (leftIndex == high) {
                    break;
                }
            while (less(key, a[--rightIndex]))
                if (rightIndex == low) {
                    break;
                }
            if (leftIndex >= rightIndex) {
                break;
            }
            exchange(a, leftIndex, rightIndex);
        }
        exchange(a, low, rightIndex);

        return rightIndex;
    }


}
