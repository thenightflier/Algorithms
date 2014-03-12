package sort;

/**
 * Created by usman on 04/03/2014.
 */
public class HeapSort {

    public static void main(String[] args) {
        Integer values[] = {0, 3, 2, 1, 4};
        HeapSort.sort(values);
        SortingUtil.print(values);

    }


    public static void sort(Comparable[] keys) {
        int size = keys.length - 1;
        for (int k = size / 2; k >= 1; k--) {
            sink(keys, k, size);
        }
        while (size > 1) {
            SortingUtil.exchange(keys, 1, size--);
            sink(keys, 1, size);
        }

    }

    private static void sink(Comparable[] keys, int start, int size) {
        while (2 * start <= size) {
            int leftChild = 2 * start;
            int rightChild = leftChild + 1;
            if (rightChild <= size && shouldBePreferredOver(keys, leftChild, rightChild)) {
                if (shouldBePreferredOver(keys, leftChild, start)) {
                    SortingUtil.exchange(keys, leftChild, start);
                    start = leftChild;
                } else {
                    break;
                }
            } else if (rightChild <= size && shouldBePreferredOver(keys, rightChild, leftChild)) {
                if (shouldBePreferredOver(keys, rightChild, start)) {
                    SortingUtil.exchange(keys, rightChild, start);
                    start = rightChild;
                } else {
                    break;
                }

            } else {
                break;
            }
        }
    }

    private static boolean shouldBePreferredOver(Comparable[] keys, int leftChild, int rightChild) {
        return SortingUtil.less(keys[leftChild], keys[rightChild]);
    }
}
