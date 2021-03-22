package com.company;

public class Persistence {

    public static void main(String[] args) {
        int n = 134475465;
        int mPers = multiplicativePersistence(n);
        int aPers = additivePersistence(n);

        System.out.println("Additive persistence of: " + aPers);
        System.out.println("Multiplicative persistence of: " + mPers);

    }

    private static int multiplicativePersistence(int m) {
        int iterations = 0;
        int tempV;

        if (m >= 10) {
            tempV = iterateM(m);
            iterations++;
        } else return iterations;

        while (tempV >= 10) {
            tempV = iterateM(tempV);
            iterations++;
        }

        return iterations;
    }

    private static int iterateM(int n) {
        int x = 1;

        while (n > 0) {
            if (n % 10 != 0) x = x * (n % 10);
            n = n / 10;
        }

        return x;
    }

    private static int additivePersistence(int m) {
        int iterations = 0;
        int tempV;

        if (m >= 10) {
            tempV = iterateA(m);
            iterations++;
        } else return iterations;

        while (tempV >= 10) {
            tempV = iterateA(tempV);
            iterations++;
        }

        return iterations;
    }

    private static int iterateA(int n) {
        int x = 0;

        while (n > 0) {
            x = x + (n % 10);
            n = n / 10;
        }

        return x;
    }
}