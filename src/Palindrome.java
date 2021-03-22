
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.next();
        boolean palindrome = true;

        for (int x = 0; x <= original.length() / 2; x++){
            if (original.charAt(x) != original.charAt(original.length()-x-1)){
                palindrome = false;
                break;
            }
        }

        System.out.println(palindrome);
    }
}