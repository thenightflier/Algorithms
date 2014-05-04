package org.usman.revision.test;

import junit.framework.TestCase;
import org.junit.Test;
import org.usman.revision.QuickSortRevision;
import utils.AlgoUtil;

import java.util.Arrays;

/**
 * Created by usman on 02/05/2014.
 */
public class QuickSortRevisionTest {

    @Test
    public void shouldSortCorrect() {
        Integer[] a = {4, 1, 3, 2, 6};
        Integer[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        QuickSortRevision.sort(a);
        AlgoUtil.print(a, b);
        TestCase.assertTrue(Arrays.deepEquals(a, b));
    }
}
