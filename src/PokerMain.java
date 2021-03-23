import java.util.Arrays;
import java.util.Scanner;

public class PokerMain {
    static int playerMoney = 1000;
    static int computerMoney = 1000;
    static int playerSmall = 1;
    static int pot = 0;
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to play poker? Yes/No");
        if (scanner.next().equals("Yes")){
            System.out.println("Ok. Let's play.");
            BeginRound();
        }
        else {
            System.out.println("Perhaps some other time...");
            System.exit(1);
        }
    }

    public static void BeginRound(){
        int[] newHand = PokerGame.GenerateNewHand();
    }
}
