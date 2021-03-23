package Poker;

import java.util.Scanner;

public class PokerMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){

        System.out.println("Would you like to play poker? Yes/No");

        if (scanner.next().equals("Yes")){
            System.out.println("Ok. Let's play.");
            PokerGame.Start();
            PokerCards.Cards();
        }

        else {
            System.out.println("Perhaps some other time...");
            System.exit(1);
        }
    }

    public static String PlayerInput(){

    }

    public static void DisplauInfo(){

    }
}
