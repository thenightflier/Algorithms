package problems.codility;

/**
 * Created by usman on 27/04/2014.
 */
public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] a = {-7, 1, 5, 2, -4, 3, 0};
        EquilibriumIndex e = new EquilibriumIndex();
        System.out.println(e.solution(a));
    }

    //
    public int solution(int[] A) {
        if (A.length < 3 || A.length > 10000000) {
            throw new IllegalArgumentException("Array can't be less ");
        }
        int index = -1;
        long leftSum = A[0];
        long total = sum(A);
        long rightSum = 0;
        for (int i = 1; i < A.length; i++) {
            rightSum = total - A[i] - leftSum;
            if (rightSum == leftSum) {
                return i;
            }
            leftSum = leftSum + A[i];

        }

        return index;

    }

    private long sum(int[] A) {
        long result = 0;
        for (int i : A) {
            result = result + i;
        }
        return result;
    }
}
