package problems.codility;

import utils.AlgoUtil;

import java.util.Arrays;

/**
 * Created by usman on 18/04/2014.
 */
public class MissingNumber {
    public static void main(String[] args) {
        Integer[] a = AlgoUtil.Distribution.MISSING_NUMBER.create(100, 1);
        System.out.println(Arrays.asList(a));
        //new int[]{2, 3, 1, 5};//{2, 3, 1, 5}
        MissingNumber m = new MissingNumber();
        System.out.println(m.solution(AlgoUtil.convert(a)));

    }

    public int solution(int[] a) {
        long result = 0;
        for (int i = 0; i <= a.length + 1; i++) {
            result = result + i;
            if (i < a.length) {
                result = result - a[i];
            }
        }
        return (int) result;
    }

}
