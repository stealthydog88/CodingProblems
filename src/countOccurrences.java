import org.apache.commons.lang3.StringUtils;

class countOccurrences {
    public static void main(String[] args){
        int i = 600004;
        int target = 451;
        int count = 0;

        String targetString = Integer.toString(target);
        for (int x = i; x >= 0; x--){
            String number = Integer.toString(x);
            if (number.contains(targetString)) System.out.println(number);
            int occurrence = StringUtils.countMatches(number, targetString);
            count = count + occurrence;
        }

        System.out.println("There are " + count + " occurrences of " + target + " between " + i + " and 0");
    }
}
