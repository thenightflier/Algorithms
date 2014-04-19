package problems.codility;

import utils.AlgoUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by usman on 18/04/2014.
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump f = new FrogJump();
//        Random random = new Random();
//        int x = random.nextInt(50);
//        int y = random.nextInt(1000);
//        while (y < x) {
//            y = random.nextInt(100);
//        }
//        int d = random.nextInt(30);
//        System.out.println(f.solution(x, y, d));//(44,14,74)
        Integer[] a = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(Arrays.asList(a));
        System.out.println(f.solution(5, AlgoUtil.convert(a)));
    }

    public int solution(int X, int Y, int D) {
        System.out.println("(" + X + "," + Y + "," + D + ")");
        int result = (Y - X) / D;
        if ((Y - X) % D > 0 && result >= 0) {
            result++;
        }
        return result;
    }

    public int solution(int X, int[] A) {
        Set<Integer> pos = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                pos.add(A[i]);
            }
            if (pos.size() == X ) {
                return i;
            }
        }
        return -1;
    }
}
