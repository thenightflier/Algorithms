package problems.codility;

/**
 * Created by usman on 21/04/2014.
 */
public class MaximalProduct {
    public static void main(String[] args) {
        MaximalProduct m = new MaximalProduct();
        System.out.println(m.solution(new int[]{-3, 1, 2, -2, 5, 6}));
    }

    public int solution(int[] A) {
        if (A.length < 3) {
            throw new IllegalArgumentException("Array should be of alleast size 3");
        }
        return 1;

    }
}
