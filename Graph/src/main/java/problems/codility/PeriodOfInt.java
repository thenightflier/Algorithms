package problems.codility;

/**
 * Created by usman on 27/04/2014.
 */
public class PeriodOfInt {
    public static void main(String[] args) {
        PeriodOfInt periodOfInt = new PeriodOfInt();
        Integer N = Integer.parseInt("111000111000",2);
        System.out.println(N);
        System.out.println(periodOfInt.solution(N));
    }

    public int solution(int N) {
        String s = Integer.toBinaryString(N);
        System.out.println(s);
        int P = s.length() / 2;
        for (int k = 0; k < s.length() - P; k++) {
            if (s.charAt(k) != s.charAt(k + P)) {
                P--;
                k = 0;
            }
        }

        return P == 0 ? -1 : P;
    }
}
