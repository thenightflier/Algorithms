package problems.codility;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function:
 * int solution(int A, int B, int K);
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * Assume that:
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Complexity:
 * expected worst-case time complexity is O(1);
 * expected worst-case space complexity is O(1).
 */
public class CountDivision {
    public static void main(String[] args) {
        CountDivision countDivision = new CountDivision();
        System.out.println(countDivision.solution(6, 110, 2));
        System.out.println(countDivision.bruteSolution(6, 110, 2));
    }

    public int solution(int A, int B, int K) {
        Double doubleA = new Double(A);
        Double doubleB = new Double(B);
        Double doubleK = new Double(K);
        int result = (int) (Math.floor(doubleB / doubleK) - Math.ceil(doubleA / doubleK));
        return result + 1;
    }

    public int bruteSolution(int A, int B, int K) {
        int count = 0;
        List<Integer> iterations = new ArrayList<Integer>();
        for (int i = A; i <= B; i++) {
            iterations.add(i);
            if (i % K == 0) {
                count++;
            }

        }
        System.out.println("problems.codility.CountDivision.bruteSolution");
        System.out.println("iterations = " + iterations);
        return count;
    }

}
