package problems.codility;

import java.util.Arrays;

/**
 * Created by usman on 18/04/2014.
 */
public class MinimalDifference {

    public static void main(String[] args) {
        Integer[] integers = {0, 10000};
                //{5, 0, 5, 9, 6};
                //{3, 1, 2, 4, 3};
        //{7, 2, 2, 7, 7};//AlgoUtil.Distribution.RANDOM.create(5);
        System.out.println(Arrays.asList(integers));
        System.out.println(solution(convert(integers)));
    }

    public static int solution(int[] a) {
        if (a.length <= 1) {
            throw new IllegalArgumentException("has to be bigger than 1");
        }
        long sum = sum(a);
        long left = a[0];
        long right = sum - a[0];
        long result = Math.abs(left - right);
        for (int i = 1; i < a.length; i++) {
            left = left + a[i];
            right = sum - left;
            long temp = Math.abs(left - right);
            if (temp < result) {
                result = temp;
            }
        }
        return (int) result;
    }

    private static long sum(int[] a) {
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result + a[i];
        }
        return result;
    }

    private static int[] convert(Integer[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i];
        }
        return result;
    }

}
