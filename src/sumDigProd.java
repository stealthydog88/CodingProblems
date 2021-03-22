
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sumDigProd {
    public static void main (String[] args){
        List<Integer> numbers = Arrays.asList(-891, -530, -33, -48, -5, -9);
        List<Integer> digits;
        boolean isNegative = false;
        int sum = sum(numbers);
        int product = 0;
        System.out.println(sum);

        if (sum < 0) isNegative = true; sum = Math.abs(sum);

        if (sum > 9){
            digits = digits(sum);
            product = product(digits);
        }
        else if (isNegative) System.out.println(-sum);
        else System.out.println(sum);

        while (product > 9){
            if (isNegative) System.out.println(-product);
            else System.out.println(product);
            digits = digits(product);
            product = product(digits);
        }

        if (isNegative) System.out.println(-product);
        else System.out.println(product);
    }

    public static int sum (List<Integer> x){
        int sum = 0;
        for (int i: x){
            sum = sum + i;
        }
        return sum;
    }

    public static List<Integer> digits (int x){
        List<Integer> digits = new ArrayList<>();
        while (x > 0){
            digits.add(x % 10);
            x = x / 10;
        }
        return digits;
    }

    public static int product(List<Integer> x){
        int a = 1;
        for (int i: x){
            a = a * i;
        }
        return a;
    }
}
