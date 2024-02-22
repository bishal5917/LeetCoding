
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        // Lets just create a candy hashmap
        int maxCanEat = candyType.length / 2;
        // Lets make a counter
        HashMap<Integer, Integer> candyMapper = new HashMap<>();
        for (int candy : candyType) {
            if (candyMapper.get(candy) == null) {
                candyMapper.put(candy, 1);
            } else {
                candyMapper.put(candy, candyMapper.get(candy));
            }
        }
        // Now lets put our logic
        int eaten = 0;
        HashSet<Integer> chosenUniques = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : candyMapper.entrySet()) {
            if (eaten == maxCanEat) {
                break;
            }
            if (entry.getValue() > 0) {
                chosenUniques.add(entry.getKey());
                candyMapper.put(entry.getKey(), entry.getValue() - 1);
                eaten += 1;
            }
        }
        return chosenUniques.size();
    }

    public static void main(String[] args) {
        int[] candyType = { 1, 1, 2, 2, 3, 3 };
        DistributeCandies obj = new DistributeCandies();
        System.out.println(obj.distributeCandies(candyType));
    }
}
