package problems.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by usman on 21/04/2014.
 */
public class DistinctValue {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Set<Integer> values = new HashSet<Integer>();
        for (int i : A) {
            values.add(i);
        }

        return values.size();
    }
}
