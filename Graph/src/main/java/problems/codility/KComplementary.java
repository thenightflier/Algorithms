package problems.codility;

import utils.AlgoUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by usman on 27/04/2014.
 */
public class KComplementary {
    public static void main(String[] args) {
        KComplementary k = new KComplementary();
        Integer a[] = AlgoUtil.Distribution.INCREASING.create(5, 1);
        a = new Integer[]{};
        int K = 0;
        System.out.println("count = " + k.solution(K, null));
        System.out.println("exact count = " + k.exactSolution(K, AlgoUtil.convert(a)));

    }

    public int solution(int k, int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        Map<Integer, Integer> integerToOccurances = getOccurances(A);
        AlgoUtil.print(A);
        int p, q;
        for (int i = 0; i < A.length; i++) {
            p = A[i];
            q = k - p;
            int indexQ = Arrays.binarySearch(A, q);
            if (indexQ >= 0) {
                System.out.println(i + "," + indexQ);
                count = count + integerToOccurances.get(q);
            }
        }
        return count;
    }

    public int exactSolution(int k, int A[]) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] + A[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private Map<Integer, Integer> getOccurances(int[] a) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i : a) {
            if (result.containsKey(i)) {
                result.put(i, result.get(i) + 1);
            } else {
                result.put(i, 1);
            }
        }
        return result;
    }


}
