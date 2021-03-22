
import java.util.Scanner;

public class FortyTwo {

    static Scanner scanner = new Scanner(System.in);
    static int score = 0;
    static int computerScore = 0;

    public static void main(String[] args){

        boolean bust = false;
        boolean computerBust;

        System.out.println("Would you like to play?");
        String input = scanner.next();

        if (input.equals("y")) bust = Game();
        else System.exit(1);

        if (score == 42) System.out.println("Wow, you got a perfect score!");

        if(bust) System.out.println("You bust at " + score + "! Better luck next time.");
        else {
            System.out.println("\r\n Let's see if the computer can beat you... \r\n");
            computerBust = ComputerGame();
            if (computerBust){
                System.out.println("\r\n The computer busted at " + computerScore + "! You Win!");
            }
            else if(computerScore > score) {
                System.out.println("\r\n The computer beat you with a score of " + computerScore + ". Better luck next time!");
            }
            else if(computerScore == score) System.out.println("\r\n The computer tied you!");
        }
    }

    public static boolean Game(){
        while (true){
            int tempScore = (int) (Math.random()*20);
            while (tempScore == 0) tempScore = (int) (Math.random()*20);
            score = score + tempScore;
            if (score > 42) break;
            System.out.println("Your score is " + score + ". Would you like to keep playing? y/n");
            if(scanner.next().equals("n")){
                System.out.println("Your final score is " + score + ".");
                break;
            }
        }
        return (score > 42);
    }

    public static boolean ComputerGame(){
        while (true){
            int tempScore = (int) (Math.random()*20);
            while (tempScore == 0) tempScore = (int) (Math.random()*20);
            computerScore = computerScore + tempScore;
            if (computerScore > 42) break;
            System.out.println("The computer's score is at " + computerScore);
            if((computerScore >= score)){
                break;
            }
        }
        return (computerScore > 42);
    }
}