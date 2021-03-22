
import java.util.ArrayList;

public class Quadratic {
    private final String result;

    // quad would be a string in this format:
    // 6x^2-17x +12
    // qA = 6
    // qB = -17
    // qC = 12
    public Quadratic(String quad) {

        quad = quad.replace("x^2", "x^2;");
        quad = quad.replace("x ", "x ;");
        String[] quadArray = quad.split(";");

        for (int i = 0; i < quadArray.length; i++) {
            if (quadArray[i].contains("x^2"))
                quadArray[i] = quadArray[i].replace("x^2", "");
            else if (quadArray[i].contains("x "))
                quadArray[i] = quadArray[i].replace("x ", "");
        }

        int qA = Integer.parseInt(quadArray[0]);
        int qB = Integer.parseInt(quadArray[1]);
        int qC = Integer.parseInt(quadArray[2]);

        var f = findFactors(qA, qB, qC);
        assert f != null;
        int f1 = f[0];
        int f2 = f[1];

        System.out.println(qA);
        System.out.println(f1);
        System.out.println(qC);
        System.out.println(f2);

        int hcf1 = findHCF(qA, f1);
        int hcf2 = findHCF(qC, f2);

        if (hcf1 == 1 && hcf2 == 1) {
            int temp = f1;
            f1 = f2;
            f2 = temp;
            hcf1 = findHCF(qA, f1);
            hcf2 = findHCF(qC, f2);
        }

        int qAoh = qA / hcf1;
        int f1oh = f1 / hcf1;

        int temp = qC * qA;
        if (hcf2 * f1oh != temp) hcf2 = -hcf2;

        if (hcf1 == 1) hcf1 = 0;
        if (qAoh == 1) qAoh = 0;
        if (hcf1 == -1) hcf1 = -69420;
        if (qAoh == -1) qAoh = -69420;

        result = String.format("(%sx+%s)(%sx+%s)", hcf1, hcf2, qAoh, f1oh)
                .replace("69420", "").replace("0", "").replace("+-", "-").replace("-+", "");
    }

    public String result() {
        return result;
    }

    // Given the 2 coefficients and the constant in a quadratic equation, find the factors used to perform the PSF method of factorisation.
    private int[] findFactors(int a, int b, int c) {
        ArrayList<Integer> productFactors = new ArrayList<>();
        int product = a * c;

        // Finds the factors of any number. Skips 0 as it is a useless factor.
        // Takes into consideration that a negative multiplied by a negative is positive.
        if (product > 0)
            for (int i = 1; i <= product; i++) {
                if (product % i != 0 || productFactors.contains(i)) continue;
                productFactors.add(i);
                productFactors.add(-i);
            }
        else if (product < 0)
            for (int i = product; i <= Math.abs(product); i++) {
                if (i == 0) continue;
                if (product % i != 0 || productFactors.contains(i)) continue;
                productFactors.add(i);
            }

        // Checks each element of the array against each other to find a pair in which the sum is equal to the
        // coefficient of 'x' and the product is equal to the product of the coefficient of 'x^2' and the constant value.
        for (int i : productFactors)
            for (int x : productFactors)
                if (x + i == b && x * i == product) return new int[]{x, i};

        // If there is no factors return null
        return null;
    }

    // Finding the lowest common factors of a and b
    private int findHCF(int a, int b) {
        // List of prime factors for a and b
        ArrayList<Integer> aP = findPrimeFactors(a);
        ArrayList<Integer> bP = findPrimeFactors(b);
        int HCF = 1;

        // If both arrays contain the same value multiply HCF by that value
        // and remove it from the array
        for (int i : aP) {
            if (bP.contains(i)) {
                HCF = HCF * i;
                bP.remove((Integer) i);
            }
        }
        return HCF;
    }

    private ArrayList<Integer> findPrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        // Sequentially divides n by prime numbers until n = 1. i.e. Until all prime factors are found.
        // Upper bound is n = 997 as 997 is the highest prime number in the list.
        int nextPrime = nextPrime(0);
        boolean done = false;
        while (!done) {
            while (n % nextPrime == 0) {
                if (nextPrime == 1) break;
                primeFactors.add(nextPrime);
                n = n / nextPrime;
            }
            switch (n) {
                case(-1):{
                    primeFactors.add(-1);
                }
                case (1): done = true;
            }
            nextPrime = nextPrime(nextPrime);
        }
        return primeFactors;
    }

    private int nextPrime(int p) {
        // increment by one so we do not find p
        p = p + 1;
        // while we haven't found any prime numbers, look
        // automatically return 1 as the first prime
        if (p == 1) return p;
        while (true) {
            // list of potential prime numbers
            ArrayList<Integer> potentialPrimeNumberFactors = new ArrayList<>();
            for (int x = 1; x <= p; x++)
                if (p % x == 0) potentialPrimeNumberFactors.add(x);
            if (potentialPrimeNumberFactors.size() == 2) return p;
            p++;
        }
    }
}
