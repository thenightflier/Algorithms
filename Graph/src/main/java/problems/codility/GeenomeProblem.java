package problems.codility;

import com.google.common.primitives.Ints;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by usman on 20/04/2014.
 */
public class GeenomeProblem {

    public static void main(String[] args) {
        System.out.println(Ints.asList(genome("GACACCATA", new int[]{0, 0, 4, 7}, new int[]{8, 2, 5, 7})));

    }

    public static int[] genome(String S, int[] P, int[] Q) {
        int len = S.length();
        int[][] arr = new int[len][4];
        int[] result = new int[P.length];

        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == 'A') arr[i][0] = 1;
            if (c == 'C') arr[i][1] = 1;
            if (c == 'G') arr[i][2] = 1;
            if (c == 'T') arr[i][3] = 1;
        }
        // compute prefixes
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] += arr[i - 1][j];
            }
        }

        for (int i = 0; i < P.length; i++) {
            int x = P[i];
            int y = Q[i];

            for (int a = 0; a < 4; a++) {
                int sub = 0;
                if (x - 1 >= 0) sub = arr[x - 1][a];
                if (arr[y][a] - sub > 0) {
                    result[i] = a + 1;
                    break;
                }
            }

        }
        return result;
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int result[] = new int[P.length];
        Map<Character, Integer> precedence = getPrecedence(S);
        char c[] = S.toCharArray();
        for (int i = 0; i < P.length; i++) {
            char left = S.charAt(P[i]);
            if (left == 'C' && i > 0) {
                left = S.charAt(P[i - 1]);
            }
            char right = S.charAt(Q[i]);
            if (right == 'C' && i > 0) {
                right = S.charAt(Q[i - 1]);
            }
            if (precedence.get(left) < precedence.get(right)) {
                result[i] = precedence.get(left);
            } else {
                result[i] = precedence.get(right);
            }
        }
        return result;
    }

    private Map<Character, Integer> getPrecedence(String s) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        result.put('A', 1);
        result.put('C', 2);
        result.put('G', 3);
        result.put('T', 4);
        return result;
    }
}

