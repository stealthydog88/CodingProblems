
import java.util.Scanner;

public class SquarePyramid
{
    public static void main(String[] args)
    {
        int n;
        int sum = 0;

        System.out.println("Enter you number here:");

        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for (int i = n; i > 0; i--)
        {
            sum = (int) (sum + Math.pow(i, 2));
        }

        System.out.println(sum);

    }
}
