package problems.codility;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import utils.AlgoUtil;

/**
 * Created by usman on 18/04/2014.
 */
public class MinimalDifferenceBenchmark {
    @Param
    AlgoUtil.Distribution distribution;
    @Param({"10", "1000", "100000"})
    private int length;
    private int[] input;

    @BeforeExperiment
    public void setUp() {
        input = convert(distribution.create(length, 1));
    }

    private int[] convert(Integer[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        return result;
    }

    @Benchmark
    public long testMergeStandard(int rep) {
        long result = 0;
        for (int i = 0; i < rep; i++) {
            result |= MinimalDifference.solution(input);
        }
        return result;
    }
}
