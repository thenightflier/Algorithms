package problems.codility;

/**
 * Created by usman on 27/04/2014.
 */
public class WholeSquare {
    public static void main(String[] args) {
        WholeSquare w = new WholeSquare();
        int b = 2147483647 / 50;
        int a = 1;
        System.out.println(a + "," + b);
        System.out.println(w.solutionAnother(a, b));
        System.out.println(w.bruteForceSolution(a, b));
    }

    public int solution(int A, int B) {
        double bSqrt = Math.sqrt(new Double(B));
        double bResult = Math.floor(bSqrt);
        double aSqrt = Math.sqrt(new Double(A));
        double aResult = Math.ceil(aSqrt);
        return (int) (bResult - aResult) + 1;
    }

    public int solutionAnother(int A, int B) {
        return (int) (Math.abs(Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A)))) + 1;
    }

    public int bruteForceSolution(int A, int B) {
        int lower = Math.min(A, B);
        int uppper = Math.max(A, B);
        int count = 0;
        for (int i = lower; i <= uppper; i++) {
            Double d = Math.sqrt(i);
            double abs = Math.ceil(Math.sqrt(i));
            if (d.equals(abs)) {
                count++;
            }
        }
        return count;
    }
}
