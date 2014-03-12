package sort;

import java.util.Arrays;

/**
 * Created by usman on 23/02/2014.
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer toSort[] = {4, 1, 3, 6, 8};
        printArray(toSort);
        sort(toSort);
        printArray(toSort);
    }

    private static void printArray(Integer[] sorted) {
        for (Integer i : sorted) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static void sort(Integer[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            int min = toSort[i];
            int indexToReplace = i;
            for (int j = i; j < toSort.length; j++) {
                if (SortingUtil.less(toSort[j], min)) {
                    min = toSort[j];
                    indexToReplace = j;
                }
            }
            if (indexToReplace != i)
                SortingUtil.exchange(toSort, i, indexToReplace);
        }
    }
}
