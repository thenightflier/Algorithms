package problem.codility;

import junit.framework.TestCase;
import org.junit.Test;
import problems.codility.CountDivision;

import java.util.Random;

/**
 * Created by usman on 03/05/2014.
 */
public class CountDivisionTest {

    @Test
    public void shouldCountCorrectRandom() {
        Random random = new Random();
        int A = random.nextInt(1000);
        int B = random.nextInt(1000);
        while (B < A) {
            B = random.nextInt(1000);
        }
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        CountDivision countDivision = new CountDivision();
        int actual = countDivision.solution(A, B, 3);
        int expected = countDivision.bruteSolution(A, B, 3);
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        TestCase.assertTrue(actual == expected);
    }


    @Test
    public void shouldCountCorrect() {
        int A = 5;
        int B = 11;
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        int K = 2;
        System.out.println("K = " + K);
        CountDivision countDivision = new CountDivision();
        int actual = countDivision.solution(A, B, K);
        int expected = countDivision.bruteSolution(A, B, K);
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        TestCase.assertTrue(actual == expected);
    }
}
