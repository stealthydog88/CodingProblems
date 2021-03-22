
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumber
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int nextDigit;
        StringBuilder firstSet = new StringBuilder();
        StringBuilder secondSet = new StringBuilder();
        StringBuilder thirdSet = new StringBuilder();
        String finalString;

        for (int i = 10; i > 0; i--)
        {
            nextDigit = scanner.nextInt();
            list.add(nextDigit);
        }

        for (int i = 0; i < 3; i++)
        {
            firstSet.append(list.get(i));
        }

        for (int i = 3; i < 6; i++)
        {
            secondSet.append(list.get(i));
        }

        for (int i = 6; i < 10; i++)
        {
            thirdSet.append(list.get(i));
        }

        finalString = "(" + firstSet + ") " + secondSet + "-" + thirdSet;
        System.out.println(finalString);

    }
}
