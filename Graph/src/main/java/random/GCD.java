package random;

import java.util.Random;

/**
 * Created by usman on 16/03/2014.
 */
public class GCD {
    public static int count = 0;

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int a = random.nextInt(1000);//  10000000, 10, 10000
            int b = random.nextInt(1000);// 10 , 10000 ,
            System.out.println("(" + a + "," + b + ")=" + gcd(a, b) + "-->" + count);
            count = 0;
        }
    }

    /**
     * Complexity:
     * Intitutively as the algorithm in the first step goes a,b --> b, a%b --> a%b, b %(a%b).
     * which is significant drop. That rules out polynomial . So i was thinking linear time or logrithmic but of what? size of a or b or both?
     * so i experimented with the input and counted the number of steps.
     * It seems that the worst case aprroximately order of number of digits of the smaller number.
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        count++;
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
