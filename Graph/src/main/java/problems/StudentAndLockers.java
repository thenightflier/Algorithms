package problems;

/**
 * Created by usman on 26/02/2014.
 */
public class StudentAndLockers {
    public static void main(String[] args) {
        int number = 8;
        for (int i = 3; i <= 1001; i++) {
            runSimulation(i);
            System.out.println();
        }

    }

    private static void runSimulation(int number) {
        boolean[] lockers = new boolean[number];
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = !lockers[i];// first student opens all the lockers
        }
        invertState(lockers);
        countLockersOpen(lockers);
    }

    private static void countLockersOpen(boolean[] lockers) {
        int count = 0;
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i]) {
                count++;
            }
        }
        System.out.print("open lockers = " + count);
        System.out.println(",kids = " + (lockers.length - 1) + " lockers = " + (lockers.length - 1));
    }

    private static void invertState(boolean[] lockers) {
        // the second student and beyond inverts the states
        for (int i = 2; i < lockers.length; i++) {
            int j = 1;
            while (i * j < lockers.length) {
                lockers[i * j] = !lockers[i * j];
                j++;
            }
        }


    }

    private static void print(boolean[] lockers) {
        for (int i = 1; i < lockers.length; i++) {
            System.out.println("locker [" + i + "] = " + translate(lockers[i]));
        }
    }

    private static String translate(boolean locker) {
        return locker ? "OPEN" : "CLOSE";
    }
}
