package sort.benchmark;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.caliper.api.BeforeRep;
import com.google.caliper.api.Macrobenchmark;
import sort.MergeSort;

import java.util.Random;

/**
 * Created by usman on 28/02/2014.
 */
public class MergeSortCaliperBenchmark {
    @Param({"10", "1000", "100000"})
    private int length;

    @Param
    Distribution distribution;

    private Integer[] toSort;
    private Integer copy[];

    @BeforeExperiment
    public void setUp() {
        toSort = distribution.create(length);
        copy = new Integer[length];
    }

    @Benchmark
    public void testMergeStandard(int rep) {
        for (int i = 0; i < rep; i++) {
            System.arraycopy(toSort, 0, copy, 0, toSort.length);
            MergeSort.sort(copy);
        }
    }

    @Benchmark
    public void testMergeThreeWay(int rep) {
        for (int i = 0; i < rep; i++) {
            System.arraycopy(toSort, 0, copy, 0, toSort.length);
            MergeSort.sortThreeWay(copy);

        }
    }


    private enum Distribution {
        INCREASING {
            @Override
            Integer[] create(int length) {
                Integer result[] = new Integer[length];
                for (int i = 0; i < length; i++) {
                    result[i] = i;
                }
                return result;
            }
        },
        DECREASING {
            @Override
            Integer[] create(int length) {
                Integer result[] = new Integer[length];
                for (int i = length - 1; i >= 0; i--) {
                    result[i] = i;
                }
                return result;
            }
        },
        SAWTOOTH {
            @Override
            Integer[] create(int length) {
                Integer result[] = new Integer[length];
                for (int i = 0; i < length; i += 5) {
                    result[i] = 0;
                    result[i + 1] = 1;
                    result[i + 2] = 2;
                    result[i + 3] = 3;
                    result[i + 4] = 4;

                }
                return result;
            }
        },
        RANDOM {
            @Override
            Integer[] create(int length) {
                Integer result[] = new Integer[length];
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    result[i] = random.nextInt();
                }
                return result;
            }

        };

        abstract Integer[] create(int length);

    }


}
