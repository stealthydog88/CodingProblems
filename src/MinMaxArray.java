

import java.util.ArrayList;
import java.util.Scanner;

public class MinMaxArray
{
    public static void main(String[] args)
    {
        ArrayList<Double> list = new ArrayList<>();
        String newNumber;
        Double largestNumber = null;
        Double smallestNumber = null;
        boolean finished = false;
        Scanner numberInput = new Scanner(System.in);

        do
        {
            newNumber = numberInput.next();
            if (newNumber.equals("Finish"))
            {
                int i;
                largestNumber = list.get(0);
                smallestNumber = list.get(0);
                for (i = 0; i < list.size(); i++)
                {
                    if (largestNumber < list.get(i))
                    {
                        largestNumber = list.get(i);
                    }
                    if (smallestNumber > list.get(i))
                    {
                        smallestNumber = list.get(i);
                    }
                }
                finished = true;
            }
            else
            {
                try
                {
                    double d = Double.parseDouble(newNumber);
                    list.add(d);
                }
                catch (NumberFormatException nfe)
                {
                    System.out.println("Invalid entry. Try again.");
                }
            }
        }
        while (!finished);

        System.out.println(largestNumber + " is the largest number.");
        System.out.println(smallestNumber + " is the smallest number.");
        System.out.println(largestNumber - smallestNumber + " is the difference between the two.");
    }
}
