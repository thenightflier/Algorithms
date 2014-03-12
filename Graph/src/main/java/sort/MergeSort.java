package sort;

/**
 * Created by usman on 23/02/2014.
 */
public class MergeSort {
    private static Comparable aux[];

    public static void main(String[] args) {
        Integer[] a = {4, 1, 3, 2, 6};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        a = new Integer[]{4, 1, 3, 2, 6, 7};
        sortThreeWay(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }

    public static void sortThreeWay(Comparable[] a) {
        createAuxArray(a);
        sortThreeWay(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a) {
        createAuxArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void createAuxArray(Comparable[] a) {
        aux = new Comparable[a.length];
    }


    private static void sortThreeWay(Comparable[] a, int low, int high) {
        //terminating condition
        if (high <= low) {
            return;
        }
        // divide into three equal part array
        int divisionLength = (high - low) / 3;//high 5 e.g = 1

        // sort left , middle and right
        int leftHigh = low + divisionLength; // 0+1 = 1
        sort(a, low, leftHigh);//0-1
        //middle
        int middleLow = leftHigh + 1;
        int middleHigh = middleLow + divisionLength;// 1+1=2
        sort(a, middleLow, middleHigh);// 2-3
        // sort right
        sort(a, middleHigh + 1, high);// ;

        // merge left , middle and right
        merge(a, low, leftHigh, middleHigh, high);

    }

    private static void merge(Comparable[] a, int low, int leftHigh, int middleHigh, int high) {
        int leftIndex = low;
        int middleIndex = leftHigh + 1;
        int rightIndex = middleHigh + 1;

        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        for (int index = 0; index <= high; index++) {
            if (leftIndex > leftHigh && middleIndex > middleHigh) {
                a[index] = aux[rightIndex++];
            } else if (leftIndex > leftHigh && rightIndex > high) {
                a[index] = aux[middleIndex++];
            } else if (getIndexForMinimumValue(aux, leftIndex, middleIndex, rightIndex) == rightIndex) {
                a[index] = aux[rightIndex++];
            } else if (getIndexForMinimumValue(aux, leftIndex, middleIndex, rightIndex) == middleIndex) {
                a[index] = aux[middleIndex++];
            } else {
                a[index] = aux[leftIndex++];
            }
        }

    }

    private static int getIndexForMinimumValue(Comparable[] aux, int leftIndex, int middleIndex, int righIndex) {

        Comparable leftValue = aux[leftIndex];
        Comparable rightValue = aux[righIndex];
        Comparable middleValue = aux[middleIndex];
        if (SortingUtil.less(rightValue, leftValue) && SortingUtil.less(rightValue, middleValue)) {
            return righIndex;
        } else if (SortingUtil.less(middleValue, leftValue) && SortingUtil.less(middleValue, rightValue)) {
            return middleIndex;
        } else {
            return leftIndex;
        }
    }

    private static void sort(Comparable[] a, int low, int high) {
        // termination condition
        if (high <= low) {
            return;
        }
        // divide the array into two sections
        int mid = low + (high - low) / 2;

        // sort left
        sort(a, low, mid);

        // sort right
        sort(a, mid + 1, high);

        // merge left and right
        merge(a, low, mid, high);

    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid + 1;

        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        for (int i = low; i <= high; i++) {
            if (leftIndex > mid) {
                a[i] = aux[rightIndex++];
            } else if (rightIndex > high) {
                a[i] = aux[leftIndex++];
            } else if (SortingUtil.less(aux[rightIndex], aux[leftIndex])) {
                a[i] = aux[rightIndex++];
            } else {
                a[i] = aux[leftIndex++];
            }
        }

    }

}
