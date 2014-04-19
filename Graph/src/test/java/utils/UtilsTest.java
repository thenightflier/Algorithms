package utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by usman on 16/03/2014.
 */
public class UtilsTest {

    @Test
    public void shouldHaveCorrectRank() {
        Integer[] toSort = AlgoUtil.Distribution.INCREASING.create(10,1);
        Arrays.sort(toSort);
//        System.out.println(AlgoUtil.rank(toSort, 0));
        for (int i = 0; i < toSort.length; i++) {
            TestCase.assertTrue(AlgoUtil.rank(toSort, i) == i);

        }

    }
}
