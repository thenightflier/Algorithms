package search;

import junit.framework.TestCase;
import org.junit.Test;
import utils.AlgoUtil;

import java.util.Arrays;

/**
 * Created by usman on 16/03/2014.
 */
public class BinarySearchTest {

    @Test
    public void shouldGetAllValueRandom() {
        Integer input[] = AlgoUtil.Distribution.RANDOM.create(10);
        System.out.println(Arrays.asList(input));
        testBinarySearchTree(input);
    }

    @Test
    public void shouldGetAllValuesIncreasing() {
        Integer input[] = AlgoUtil.Distribution.INCREASING.create(10);
        System.out.println(Arrays.asList(input));
        testBinarySearchTree(input);

    }


    @Test
    public void shouldGetAllValuesDecreasing() {
        Integer input[] = AlgoUtil.Distribution.DECREASING.create(10);
        System.out.println(Arrays.asList(input));
        testBinarySearchTree(input);

    }

    private void testBinarySearchTree(Integer[] input) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
        for (Integer i : input) {
            bst.put(i, i);
        }
        for (Integer i : input) {
            TestCase.assertEquals(i, bst.get(i));
        }
    }
}
