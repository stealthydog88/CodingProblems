package Poker;

import java.util.HashMap;

public class PokerCards {
    static HashMap<Integer, String> cards = new HashMap<>();
    static String[] suits = {"h", "d", "c", "s"};
    static String[] faceCards = {"A", "K", "Q", "J"};

    public static void Cards(){
        for (int x = 2; x <= 10; x++) cards.put(x, x + "h");
        for (int x = 15; x <= 23; x++) cards.put(x, x + "d");
        for (int x = 28; x <= 36; x++) cards.put(x, x + "c");
        for (int x = 41; x <= 49; x++) cards.put(x, x + "s");
        for (int x = 1; x <= 52; x = x + 13) cards.put(x, "A" + suits[(x-1)/13]);
        for (int x = 11; x <= 52; x = x + 13) cards.put(x, "J" + suits[(x-11)/13]);
        for (int x = 12; x <= 52; x = x + 13) cards.put(x, "Q" + suits[(x-12)/13]);
        for (int x = 13; x <= 52; x = x + 13) cards.put(x, "K" + suits[(x-13)/13]);
    }

    public static String[] CardsInHand(int[] x){
        String[] hand = new String[5];
        for (int y = 0; y < x.length; y++){
            hand[y] = cards.get(x[y]);
        }
        return hand;
    }

    public static int HandValue(int[] x){

    }
}
