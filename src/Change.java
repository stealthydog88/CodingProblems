
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Change {
    public LinkedHashMap<String, Integer> FindChange(double x) {
        // rounds up to nearest 0.05 if necessary. No need to round down as the code will not factor that remainder in.
        if (x % 0.05 > 0.025) x = x +(0.05 - x % 0.05);

        double[] cashTypes = {100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05};

        LinkedHashMap<String, Integer> changeDistribution = new LinkedHashMap<>();
                changeDistribution.put("100", 0);
                changeDistribution.put("50", 0);
                changeDistribution.put("20", 0);
                changeDistribution.put("10", 0);
                changeDistribution.put("5", 0);
                changeDistribution.put("2", 0);
                changeDistribution.put("1", 0);
                changeDistribution.put("0.5", 0);
                changeDistribution.put("0.2", 0);
                changeDistribution.put("0.1", 0);
                changeDistribution.put("0.05", 0);

        // find the largest multiple of 100 that is less than the change.
        // replace the value of "100" above with how many 100's that is.
        // reduce the change by the multiple.
        // repeat for each cash type.
        for (double cashType : cashTypes) {
            if (x == 0) break;
            Map<String, Integer> z = Distribution(x, cashType);
            x = leftOver(x, cashType);
            for (Map.Entry<String, Integer> entry : z.entrySet()){
                String k = entry.getKey();
                int v = entry.getValue();
                changeDistribution.put(k, v);
            }
        }

        return changeDistribution;
    }

    // finds the left over change after the highest multiple of the cash type is subtracted
    public double leftOver (double moneyLeft, double moneyType){
        while(moneyLeft >= moneyType){
            moneyLeft = moneyLeft - moneyType;
        }
        return moneyLeft;
    }

    // returns how many multiples of the cash type are within the change in the form of a hashmap. (type of money, how many multiples)
    // the cash type is converted into an integer and then into a string so it corresponds to the key above. (no decimal places)
    public HashMap<String, Integer> Distribution (double moneyLeft, double moneyType){
        int count = 0;
        String y = Double.toString(moneyType);
        if (moneyType >= 1) y = String.valueOf((int) moneyType);
        HashMap<String, Integer> z = new HashMap<>();
        while (moneyLeft >= moneyType){
            moneyLeft = moneyLeft - moneyType;
            count++;
        }
        z.put(y,count);
        return z;
    }
}
