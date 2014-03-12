package sort;

/**
 * Created by usman on 01/03/2014.
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer a[] = new Integer[]{5, 4, 1, 3, 2, 6, 7};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }

    public static void sort(Comparable a[]) {
        // shuffle
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable a[], int low, int high) {
        // terminating condition
        if (high <= low) {
            return;
        }
        // partition the array
        int partition = partition(a, low, high);
        // sort left array
        sort(a, low, partition - 1);// -1 because a[partition] is sorted
        // sort right array;
        sort(a, partition + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int leftIndex = low;
        int rightIndex = high + 1;

        Comparable key = a[low];
        while (true) {

            // from the left find the value higher the key
            while (SortingUtil.less(a[++leftIndex], key)) {
                if (leftIndex == high) {
                    break;
                }
            }
            // from the right find the value smaller than the key
            while (SortingUtil.less(key, a[--rightIndex])) {
                if (rightIndex == low) {
                    break;
                }
            }
            // exchange the two values found
            if (leftIndex >= rightIndex) {
                break;
            }
            // termination condition
            SortingUtil.exchange(a, leftIndex, rightIndex);
        }
        SortingUtil.exchange(a, low, rightIndex);
        return rightIndex;

    }
}
