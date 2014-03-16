package sort;

import utils.AlgoUtil;

/**
 * Created by usman on 04/03/2014.
 */
public class HeapSort {

    public static void main(String[] args) {
        Integer values[] = AlgoUtil.Distribution.SAWTOOTH.create(10);
        HeapSort.sort(values);
        AlgoUtil.print(values);

    }


    public static void sort(Comparable[] keys) {
        int size = keys.length - 1;
        for (int k = size / 2; k >= 1; k--) {
            sink(keys, k, size);
        }
        while (size > 1) {
            AlgoUtil.exchange(keys, 1, size--);
            sink(keys, 1, size);
        }

    }

    private static void sink(Comparable[] keys, int currentIndex, int size) {
        while (2 * currentIndex <= size) {
            int leftIndex = 2 * currentIndex;
            int rightIndex = leftIndex + 1;
            int childIndex = leftIndex;
            if (leftIndex < size && !shouldBePreferredOver(keys, leftIndex, rightIndex)) {
                childIndex = rightIndex;
            }
            if (shouldBePreferredOver(keys, currentIndex, childIndex)) {
                break;
            }
            AlgoUtil.exchange(keys, currentIndex, childIndex);
            currentIndex = childIndex;
        }
    }

    private static boolean shouldBePreferredOver(Comparable[] keys, int leftChild, int rightChild) {
        return AlgoUtil.less(keys[leftChild], keys[rightChild]);
    }
}
