package sort;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.Arrays;

/**
 * Created by usman on 01/03/2014.
 */
public class MergeSortTest {
    @Rule
    public TestRule rule = new BenchmarkRule();

    @Test
    public void mergeSortTest(){
        Integer toSort [] ={7,6,3,8,1,3,0,5,3};
        Integer toSort1 []=toSort.clone();
        MergeSort.sort(toSort);
        Arrays.sort(toSort1);
        TestCase.assertTrue(Arrays.equals(toSort, toSort1));
    }

}
