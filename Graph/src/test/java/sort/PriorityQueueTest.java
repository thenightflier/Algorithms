package sort;

import datastructures.PriorityQueueReplay;
import junit.framework.TestCase;
import org.junit.Test;
import utils.AlgoUtil;

import java.util.Arrays;

/**
 * Created by usman on 15/03/2014.
 */
public class PriorityQueueTest {

    @Test
    public void shouldDeleteMin() {

        for (int i = 0; i < 100; i++) {
            comparePriorityQueue();
        }

    }

    private void comparePriorityQueue() {
        PriorityQueueReplay replay = new PriorityQueueReplay(10);
        Integer[] original = AlgoUtil.Distribution.RANDOM.create(replay.getMaximumSize());
        Integer[] sorted = Arrays.copyOf(original, original.length);
        Arrays.sort(sorted);
//        System.out.println(Arrays.asList(sorted));
        for (Integer i : original) {
            replay.addItem(i);
        }
//        System.out.println(Arrays.asList(replay.getItems()));
        for (Integer i : sorted) {
            Comparable actual = replay.deleteMin();
            TestCase.assertEquals("" + i, i, actual);
        }
    }
}
