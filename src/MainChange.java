
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class ChangeMain {
    public static void main(String[] args){
        Change x = new Change();
        double changeRequired;
        Scanner scanner = new Scanner(System.in);
        changeRequired = scanner.nextDouble();

        LinkedHashMap<String, Integer> change = x.FindChange(changeRequired);

        System.out.println("Your change is:");

        for (Map.Entry<String, Integer> entry : change.entrySet()){
            String k = entry.getKey();
            int v = entry.getValue();
            System.out.println("$" + k + ": " + v);
        }
    }
}
