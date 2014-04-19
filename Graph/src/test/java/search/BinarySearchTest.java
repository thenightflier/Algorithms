package search;

import junit.framework.TestCase;
import org.junit.Test;
import utils.AlgoUtil;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by usman on 16/03/2014.
 */
public class BinarySearchTest {

    @Test
    public void shouldGetAllValueRandom() {
        Integer input[] = AlgoUtil.Distribution.RANDOM.create(10,100);
        System.out.println(Arrays.asList(input));
        testBinarySearchTree(input);
    }

    @Test
    public void shouldGetAllValuesIncreasing() {
        Integer input[] = AlgoUtil.Distribution.INCREASING.create(10,1);
        System.out.println(Arrays.asList(input));
        testBinarySearchTree(input);

    }


    @Test
    public void shouldGetAllValuesDecreasing() {
        Integer input[] = AlgoUtil.Distribution.DECREASING.create(10,1);
        System.out.println(Arrays.asList(input));
        testBinarySearchTree(input);

    }

    @Test
    public void shouldGetMinimum() {
        Integer input[] = AlgoUtil.Distribution.RANDOM.create(10,1);
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
        for (Integer i : input) {
            bst.put(i, i);
        }
        Arrays.sort(input);
        System.out.println(Arrays.asList(input));
        TestCase.assertEquals("expected value " + input[0], input[0], bst.minimum());

    }

    @Test
    public void shouldGetMaximum() {
        Integer input[] = AlgoUtil.Distribution.RANDOM.create(10,1);
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
        for (Integer i : input) {
            bst.put(i, i);
        }
        Arrays.sort(input);
        System.out.println(Arrays.asList(input));
        TestCase.assertEquals("expected value " + input[input.length - 1], input[input.length - 1], bst.maximum());

    }

    @Test
    public void shouldGetFloor() {
        Integer input[] = AlgoUtil.Distribution.RANDOM.create(10,1);
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
        TreeMap<Integer, Integer> inputMap = new TreeMap<Integer, Integer>();
        for (Integer i : input) {
            bst.put(i, i);
            inputMap.put(i, i);
        }

        TestCase.assertEquals("expected value " + input[3], inputMap.floorKey(input[3]), bst.floor(input[3]));

    }

    @Test
    public void shouldGetCorrectCeil() {
        Integer input[] = AlgoUtil.Distribution.RANDOM.create(10,1);
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
        TreeMap<Integer, Integer> inputMap = new TreeMap<Integer, Integer>();
        for (Integer i : input) {
            bst.put(i, i);
            inputMap.put(i, i);
        }

        TestCase.assertEquals("expected value " + input[3], inputMap.ceilingKey(input[3]), bst.ceil(input[3]));

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
