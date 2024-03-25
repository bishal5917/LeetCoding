import java.util.HashMap;
import java.util.Map;

public class MaximumPopulationYear {

    public int maximumPopulation(int[][] logs) {
        int maxPopYear = Integer.MAX_VALUE;
        int maxPop = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        // check for every logs
        for (int[] log : logs) {
            int birthYr = log[0];
            int deathYr = log[1];
            for (int yr = birthYr; yr < deathYr; yr++) {
                if (count.containsKey(yr)) {
                    count.put(yr, count.get(yr) + 1);
                } else {
                    count.put(yr, 1);
                }
            }
        }
        System.out.println(count);
        // Now go over the hashmap and find the maxPopulation
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            maxPop = Math.max(maxPop, entry.getValue());
        }
        // Now go over the hashmap again and find the min maxPopulation Year
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == maxPop) {
                maxPopYear = Math.min(maxPopYear, entry.getKey());
            }
        }
        return maxPopYear;
    }

    public static void main(String[] args) {
        MaximumPopulationYear obj = new MaximumPopulationYear();
        int[][] logs = { { 1950, 1961 }, { 1960, 1971 }, { 1970, 1981 } };
        System.out.println(obj.maximumPopulation(logs));
    }
}
