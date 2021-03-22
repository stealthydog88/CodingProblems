package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumber
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int nextDigit;
        String firstSet = "";
        String secondSet = "";
        String thirdSet = "";
        String finalString = "";

        for (int i = 10; i > 0; i--)
        {
            nextDigit = scanner.nextInt();
            list.add(nextDigit);
        }

        for (int i = 0; i < 3; i++)
        {
            firstSet = firstSet + list.get(i);
        }

        for (int i = 3; i < 6; i++)
        {
            secondSet = secondSet + list.get(i);
        }

        for (int i = 6; i < 10; i++)
        {
            thirdSet = thirdSet + list.get(i);
        }

        finalString = "(" + firstSet + ") " + secondSet + "-" + thirdSet;
        System.out.println(finalString);

    }
}
