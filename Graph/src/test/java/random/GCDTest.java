package random;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by usman on 16/03/2014.
 */
public class GCDTest {

    @Test
    public void isGCDCorrect() {
        BigInteger a = new BigInteger(String.valueOf(1671232222));
        BigInteger b = new BigInteger(String.valueOf(8159));

        BigInteger gcd = a.gcd(b);
        int gcd1 = GCD.gcd(a.intValue(), b.intValue());
        System.out.println(GCD.count);
        TestCase.assertEquals(gcd.intValue(), gcd1);
//        TestCase.assertEquals(gcd.intValue(), GCD.egcd(b.intValue(), a.intValue()));
    }
}
