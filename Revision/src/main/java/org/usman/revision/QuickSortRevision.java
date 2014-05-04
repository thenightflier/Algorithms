package org.usman.revision;

import utils.AlgoUtil;

/**
 * Created by usman on 02/05/2014.
 */
public class QuickSortRevision {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        // terminating condition
        if (high <= low) {
            return;

        }
        // find partition
        int partition = partition(a, low, high);

        // sort left
        sort(a, low, partition - 1);
        sort(a, partition + 1, high);

        // sort right
    }

    private static int partition(Comparable[] a, int low, int high) {
        Comparable key = a[low];
        int leftIndex = low;
        int rightIndex = high + 1;
        while (leftIndex <= rightIndex) {
            while (AlgoUtil.less(a[++leftIndex], key)) {
                if (leftIndex == high) {
                    break;
                }
            }

            while (AlgoUtil.less(key, a[--rightIndex])) {
                if (rightIndex == low) {
                    break;
                }
            }
            if (leftIndex >= rightIndex) {
                break;
            }

            AlgoUtil.exchange(a, leftIndex, rightIndex);
        }
        AlgoUtil.exchange(a, low, rightIndex);
        return rightIndex;

    }


}
