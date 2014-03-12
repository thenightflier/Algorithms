package sort;

/**
 * Created by usman on 06/03/2014.
 */
public class QuickSortTest {

    public static void main(String[] args) {
        Integer a[] = new Integer[]{5, 4, 7, 3, 2, 6, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }

    private static void sort(Comparable[] toSort, int low, int high) {
        // terminating condition
        if (high <= low) {
            return;
        }
        // partition
        int partition = partition(toSort, low, high);

        // sort left
        sort(toSort, low, partition - 1);
        sort(toSort, partition + 1, high);

        //sort right


    }

    private static int partition(Comparable[] toSort, int low, int high) {
        int leftIndex = low;
        int rightIndex = high + 1;
        Comparable key = toSort[low];
        while (leftIndex < rightIndex) {
            while (SortingUtil.less(toSort[++leftIndex], key)) {
                if (leftIndex == high) {
                    break;
                }
            }
            while (SortingUtil.less(key, toSort[--rightIndex])) {
                if (rightIndex == low) {
                    break;
                }
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            SortingUtil.exchange(toSort, leftIndex, rightIndex);
        }
        SortingUtil.exchange(toSort, low, rightIndex);
        return rightIndex;
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
}
