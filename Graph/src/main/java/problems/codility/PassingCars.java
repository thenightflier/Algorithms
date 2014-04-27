package problems.codility;

import com.google.common.primitives.Ints;

/**
 * Created by usman on 20/04/2014.
 */
public class PassingCars {
    public static void main(String[] args) {
        int[] input = {0, 1, 0, 1, 1, 1};
        System.out.println(Ints.asList(input));
        System.out.println(new PassingCars().solution(input));
    }

    public int solution(int a[]) {
        if (a.length == 1) {
            return 0;
        }
        boolean seenZero = false;
        int increament = 0;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                seenZero = true;
                increament++;
            } else if (a[i] == 1 && seenZero) {
                result = result + increament;
                if (result > 1000000000) {
                    return -1;
                }
            }
        }
        return result;
    }
}
