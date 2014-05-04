package random;

import java.util.*;

/**
 * Created by usman on 30/04/2014.
 */
public class HashCollectionsExperiment {
    public static void main(String[] args) {
        testForSameKeys();
        testTreeMap();


    }

    public static void testForSameKeys() {
        Map<BadInteger, String> test = new HashMap<BadInteger, String>();
        test.put(new BadInteger(1), "One");
        test.put(new BadInteger(2), "Two");

        System.out.println(test.get(new BadInteger(2)));
        System.out.println(test.get(new BadInteger(1)));


        Map<Integer, String> test2 = new HashMap<Integer, String>();
        test2.put(1, "one");
        test2.put(1, "Tw0");
        test2.put(null, "three in NULL");
        System.out.println(test2.size());
        System.out.println("overwrites the old value = " + test2.get(1));
        System.out.println("value stored for null = " + test2.get(null));

        Set<BadInteger> anotherSEt = new HashSet<BadInteger>();
        anotherSEt.add(new BadInteger(1));
        anotherSEt.add(new BadInteger(2));
        anotherSEt.add(null);
        System.out.println("Set Test");
        for (BadInteger i : anotherSEt) {
            System.out.println(i);
        }
    }

    private static void testTreeMap() {
        Map<BadInteger, String> test = new TreeMap<BadInteger, String>();
        test.put(new BadInteger(1), "");
    }
}

class BadInteger {
    private final int value;

    public BadInteger(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BadInteger that = (BadInteger) o;

        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "BadInteger{" +
                "value=" + value +
                '}';
    }
}


