
import java.util.ArrayList;

public class SmithNumbers{
    public static void main (String[] args){

        for (int x = 1; x <= 10; x++){
            x = TypeSmith(x);

            switch (x) {
                case (1) -> System.out.println(x + ": Not a Smith Number");
                case (2) -> System.out.println(x + ": Trivial Smith");
                case (3) -> System.out.println(x + ": Single Smith");
                case (4) -> System.out.println(x + ": Younger Smith");
                case (5) -> System.out.println(x + ":Older Smith");
                case (6) -> System.out.println(x + ":Middle Smith");
            }
        }
    }

    private static int TypeSmith(int n){

        boolean isPrime = IsPrime(n);
        if(isPrime) return 2;

        boolean lowerN = FindSmith(n - 1);
        boolean N = FindSmith(n);
        boolean upperN = FindSmith(n + 1);

        if (!N) return 1;
        else if (!lowerN && !upperN) return 3;
        else if (!lowerN) return 4;
        else if (!upperN) return 5;
        else return 6;
    }

    private static boolean FindSmith(int n){
        int digitalSum = FindDigitalSum(n);
        while(digitalSum > 9) digitalSum = FindDigitalSum(digitalSum);
        int primeDigitalSum = FindPrimeDigitalSum(n);

        return digitalSum == primeDigitalSum;
    }

    private static int FindDigitalSum(int n){
        int x = 0;

        while (n > 0) {
            if (n % 10 != 0) x = x + (n % 10);
            n = n / 10;
        }

        return x;
    }

    private static int FindPrimeDigitalSum(int n){
        ArrayList<Integer> primeFactors = FindPrimeFactors(n);
        int primeSum = 0;
        int primeDigitalSum;
        for (int factor : primeFactors) primeSum = primeSum + factor;
        primeDigitalSum = FindDigitalSum(primeSum);
        while(primeDigitalSum > 9) primeDigitalSum = FindDigitalSum(primeDigitalSum);
        return primeDigitalSum;
    }

    private static boolean IsPrime(int n){
        boolean isPrime = false;
        ArrayList<Integer> primeFactors = FindPrimeFactors(n);
        if (primeFactors.size() == 1) isPrime = true;
        return isPrime;
    }

    private static ArrayList<Integer> FindPrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        // Sequentially divides n by prime numbers until n = 1. i.e. Until all prime factors are found.
        // Upper bound is n = 997 as 997 is the highest prime number in the list.
        int nextPrime = NextPrime(0);
        boolean done = false;
        while (!done) {
            while (n % nextPrime == 0) {
                if (nextPrime == 1) break;
                primeFactors.add(nextPrime);
                n = n / nextPrime;
            }
            if (n == 1) done = true;
            nextPrime = NextPrime(nextPrime);
        }
        return primeFactors;
    }

    private static int NextPrime(int p) {
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
