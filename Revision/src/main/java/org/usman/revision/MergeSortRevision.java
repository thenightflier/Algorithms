package org.usman.revision;

import edu.princeton.cs.introcs.StdDraw;
import utils.AlgoUtil;

/**
 * Created by usman on 02/05/2014.
 */
public class MergeSortRevision {

    private static Comparable aux[];

    public static void main(String[] args) {
        StdDraw.square(.2, .8, .1);
        StdDraw.filledSquare(.8, .8, .2);
        StdDraw.circle(.8, .2, .2);

        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(.02);
        StdDraw.arc(.8, .2, .1, 200, 45);

        // draw a blue diamond
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        double[] x = {.1, .2, .3, .2};
        double[] y = {.2, .3, .2, .1};
        StdDraw.filledPolygon(x, y);

        // text
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.2, 0.5, "black text");
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0.8, 0.8, "white text");
    }

    public static void sort(Comparable a[]) {

        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        // terminating condition
        if (high <= low) {
            return;
        }
        // divide into two arrays
        int mid = low + (high - low) / 2;
        // sort left and right
        sort(a, low, mid);
        sort(a, mid + 1, high);

        // merge left and right
        merge(a, low, mid, high);

    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        // copy stuff to aux array .
        // and then compare and copy to the original array .
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
        int leftIndex = low;
        int rightIndex = mid + 1;
        for (int i = low; i <= high; i++) {
            if (isleftExhausted(leftIndex, mid)) {
                rightIndex = copyAndIncrementIndex(a, rightIndex, i);
            } else if (isRightExhausted(rightIndex, high)) {
                leftIndex = copyAndIncrementIndex(a, leftIndex, i);
            } else if (isRightLessThanLess(leftIndex, rightIndex)) {
                rightIndex = copyAndIncrementIndex(a, rightIndex, i);
            } else {
                leftIndex = copyAndIncrementIndex(a, leftIndex, i);
            }
        }
    }

    private static boolean isRightLessThanLess(int leftIndex, int rightIndex) {
        return AlgoUtil.less(aux[rightIndex], aux[leftIndex]);
    }

    private static int copyAndIncrementIndex(Comparable[] a, int index, int i) {
        a[i] = aux[index++];
        return index;
    }

    private static boolean isRightExhausted(int rightIndex, int high) {
        return rightIndex > high;
    }

    private static boolean isleftExhausted(int leftIndex, int mid) {
        return leftIndex > mid;

    }

}
