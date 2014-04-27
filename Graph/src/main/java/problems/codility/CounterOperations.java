package problems.codility;

import com.google.common.primitives.Ints;
import utils.AlgoUtil;

/**
 * Created by usman on 19/04/2014.
 */
public class CounterOperations {
    public static void main(String[] args) {
        CounterOperations c = new CounterOperations();
        int a[] = {6, 4, 4, 6, 1, 4, 4};
        System.out.println(Ints.asList(a));
        AlgoUtil.print(c.solutionCorrect(5, a));
        AlgoUtil.print(c.solution(5, a));
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int lastUpdate = 0;
        int maxValue = 0;
        for (int i = 0; i < A.length; i++) {
            int position = A[i] - 1;
            if (position == N) {
                lastUpdate = maxValue;
            } else {
                if (counters[position] < lastUpdate) {
                    counters[position] = lastUpdate + 1;
                } else {
                    counters[position]++;

                }

                if (counters[position] > maxValue) {
                    maxValue = counters[position];
                }
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastUpdate) {
                counters[i] = lastUpdate;
            }

        }
        return counters;
    }

    public int[] solutionCorrect(int N, int[] A) {
        int[] counters = new int[N];
        int maxValue = 0;
        boolean alreadySetToMax = false;
        for (int i = 0; i < A.length; i++) {
            int index = A[i] - 1;
            if (index < N) {
                counters[index]++;
                if (maxValue < counters[index]) {
                    maxValue = counters[index];
                }
                alreadySetToMax = false;
            } else {
                if (!alreadySetToMax) {
                    resetToMax(counters, maxValue);
                    alreadySetToMax = true;
                }
            }
        }

        return counters;

    }

    private void resetToMax(int[] a, int maxValue) {
        for (int i = 0; i < a.length; i++) {
            a[i] = maxValue;
        }
    }
}
