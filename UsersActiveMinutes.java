import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] activeMins = new int[k];
        HashMap<Integer, HashSet<Integer>> bucket = new HashMap<>();
        for (int[] log : logs) {
            if (bucket.get(log[0]) == null) {
                HashSet<Integer> mins = new HashSet<>();
                mins.add(log[1]);
                bucket.put(log[0], mins);
            } else {
                HashSet<Integer> mins = bucket.get(log[0]);
                mins.add(log[1]);
                bucket.put(log[0], mins);
            }
        }
        System.out.println(bucket);
        // Now iterate over that hashmap and keep adding the values in the final array
        for (Map.Entry<Integer, HashSet<Integer>> entry : bucket.entrySet()) {
            HashSet<Integer> mins = bucket.get(entry.getKey());
            int length = mins.size();
            activeMins[length - 1] = activeMins[length - 1] + 1;
        }

        return activeMins;
    }

    public static void main(String[] args) {
        UsersActiveMinutes obj = new UsersActiveMinutes();
        int[][] logs = { { 0, 5 }, { 1, 2 }, { 0, 2 }, { 0, 5 }, { 1, 3 } };
        int k = 5;
        int[] ans = obj.findingUsersActiveMinutes(logs, k);
        System.out.println(Arrays.toString(ans));

    }

}
