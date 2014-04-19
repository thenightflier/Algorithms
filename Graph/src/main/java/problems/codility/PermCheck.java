package problems.codility;

import utils.AlgoUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by usman on 19/04/2014.
 */
public class PermCheck {
    public static void main(String[] args) {
        Integer[] a = {1, 10, 4, 5, 9, 2, 3, 8, 6, 7};
//        Integer[] a = AlgoUtil.Distribution.MISSING_NUMBER.create(10, 1);
        System.out.println(Arrays.asList(a));
        //new int[]{2, 3, 1, 5};//{2, 3, 1, 5}
        PermCheck m = new PermCheck();
        System.out.println(m.solutionArray(AlgoUtil.convert(a)));
    }

    public int solution(int a[]) {
        Map<Integer, Integer> unique = getUnique(a.length);
        for (int i = 0; i < a.length; i++) {
            if (!unique.containsKey(a[i]) || unique.get(a[i]) > 1) {
                return 0;
            } else {
                unique.put(a[i], unique.get(a[i]) + 1);
            }
        }
        return 1;
    }

    private Map<Integer, Integer> getUnique(int length) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>(length + 1);
        for (int i = 0; i <= length; i++) {
            result.put(i, 1);
        }
        return result;
    }

    public int solutionArray(int[] a) {
        boolean[] order = new boolean[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < order.length) {
                order[a[i]] = true;
            } else {
                return 0;
            }
        }
        order[0] = true;
        for (boolean b : order) {
            if (!b) {
                return 0;
            }
        }
        return 1;
    }

}
