
import java.util.Scanner;

public class FourtyTwo {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("Would you like to play?");
        String input = scanner.next();
        boolean bust = false;
        boolean computerBust = false;

        if (input.equals("yes")) bust = Game();
        else System.out.println("bruh"); System.exit(1);

        if(bust) System.out.println("You bust! Better luck next time.");
    }

    public static boolean Game(){
        int score = 0;
        while (score < 42){
            score = (int) (Math.random()*20);
            System.out.println("Your score is " + score + ". Would you like to keep playing? yes/no");
            if (scanner.next().equals("yes")) continue;
            else if(scanner.next().equals("no")){
               // System.out
            }
        }

        return (score > 42);
    }

//    public static boolean ComputerGame(){
//
//    }
}
