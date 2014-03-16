package sort;

import junit.framework.TestCase;
import org.junit.Test;
import utils.AlgoUtil;

import java.util.Arrays;

/**
 * Created by usman on 15/03/2014.
 */
public class QuickSortTest {

    @Test
    public void shouldSortRegression() {

        for (int i = 0; i < 100; i++) {
            Integer toSort[] = AlgoUtil.Distribution.RANDOM.create(10);
            Integer[] sorted = Arrays.copyOf(toSort, toSort.length);
            Integer[] sortedByJava = Arrays.copyOf(toSort, toSort.length);
            QuickSortReplay.sort(sorted);
            Arrays.sort(sortedByJava);
            boolean passed = Arrays.deepEquals(sorted, sortedByJava);
            if (!passed) {
                System.out.println("unsorted - " + Arrays.asList(toSort));
                System.out.println("My quick " + Arrays.asList(sorted));
                System.out.println("sorted " + Arrays.asList(sortedByJava));
            }
            TestCase.assertTrue(passed);
        }

    }

    @Test
    public void shouldSortRegressionQS() {

        for (int i = 0; i < 100; i++) {
            Integer toSort[] = AlgoUtil.Distribution.RANDOM.create(10);
            Integer[] sorted = Arrays.copyOf(toSort, toSort.length);
            Integer[] sortedByJava = Arrays.copyOf(toSort, toSort.length);
            QuickSort.sort(sorted);
            Arrays.sort(sortedByJava);
            boolean passed = Arrays.deepEquals(sorted, sortedByJava);
            if (!passed) {
                System.out.println(Arrays.asList(toSort));
                System.out.println(Arrays.asList(sorted));
                System.out.println(Arrays.asList(sortedByJava));
            }
            TestCase.assertTrue(passed);
        }

    }

}
