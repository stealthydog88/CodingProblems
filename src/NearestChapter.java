
import java.util.ArrayList;
import java.util.Map;

public class NearestChapter {
    public static void main (String[] args){
        int pageNumber = 45;
        int currentClosest;
        int closestDifference;
        ArrayList<Integer> pages = new ArrayList<>();
        Map<String, Integer> chapters = Map.of(
                "Chapter 1", 1,
                "Chapter 2", 30,
                "Chapter 3", 60,
                "Chapter 4", 97
        );

        for (Map.Entry<String, Integer> values : chapters.entrySet()){
            pages.add(values.getValue());
        }

        System.out.println(pages);

        currentClosest = pages.get(0);
        closestDifference = Math.abs(pages.get(0) - pageNumber);

        for (int i = 1; i < pages.size(); i++){
            if (Math.abs(pages.get(i) - pageNumber) < closestDifference){
                closestDifference = Math.abs(pages.get(i) - pageNumber);
                currentClosest = pages.get(i);
            }
            else if(Math.abs(pages.get(i) - pageNumber) == closestDifference && pages.get(i) > currentClosest) currentClosest = pages.get(i);
        }

        for (Map.Entry<String, Integer> entry: chapters.entrySet()){
            if (entry.getValue() == currentClosest) System.out.println(entry.getKey());
        }
    }
}
