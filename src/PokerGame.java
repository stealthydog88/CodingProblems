import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PokerGame {
    static ArrayList<Integer> deck = new ArrayList<>();

    // Generate new hands for player and computer at the start of each turn.
    public static int[] GenerateNewHand(){

        SecureRandom secureRandom = new SecureRandom();
        int[] playerHand = new int[5];
        int[] computerHand = new int[5];

        if(!(PokerMain.playerMoney % 2 == 0)){
            PokerMain.playerMoney = PokerMain.playerMoney - 50;
            PokerMain.computerMoney = PokerMain.computerMoney - 25;
            PokerMain.pot = PokerMain.pot + 75;
        }
        else {
            PokerMain.playerMoney = PokerMain.playerMoney - 25;
            PokerMain.computerMoney = PokerMain.computerMoney - 50;
            PokerMain.pot = PokerMain.pot + 75;
        }

        for (int i = 1; i <= 52; i++){
            deck.add(i);
        }

        for (int i = 0; i <= 4; i++){
            int random = secureRandom.nextInt(deck.size()-1);
            while (deck.get(random) == 0) random = secureRandom.nextInt(deck.size()-1);
            playerHand[i] = deck.get(random);
            deck.set(random, 0);
        }

        for (int i = 0; i <= 4; i++) {
            int random = secureRandom.nextInt(deck.size() - 1);
            while (deck.get(random) == 0) random = secureRandom.nextInt(deck.size() - 1);
            computerHand[i] = deck.get(random);
            deck.set(random, 0);
        }

        System.out.println(Arrays.toString(playerHand));
        System.out.println(Arrays.toString(computerHand));

        PokerComputer.ComputerLogic(computerHand);
        return playerHand;
    }

    public static boolean PlayerInputFirst(String y){
        Scanner scanner = new Scanner(System.in);
        if (y.equals("Fold")) return false;
        else if(y.equals("Raise")){
            System.out.println("How much would you like to raise?");
            int amount = scanner.nextInt();
            PokerMain.playerMoney = PokerMain.playerMoney - amount;
            PokerMain.pot = PokerMain.pot + amount;
            return true;
        }
    }
}
