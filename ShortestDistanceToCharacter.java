import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToCharacter {

    public int[] shortestToChar(String s, char c) {
        List<Integer> occurences = new ArrayList<>();
        int[] distance = new int[s.length()];
        // Get the occurences
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                occurences.add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            // Now calculate the each and every occurence and put the minimum occurence
            int currMinDistance = Integer.MAX_VALUE;
            for (int j = 0; j < occurences.size(); j++) {
                currMinDistance = Math.min(currMinDistance, Math.abs(i - occurences.get(j)));
            }
            distance[i] = currMinDistance;
        }
        System.out.println(occurences);
        return distance;
    }

    public static void main(String[] args) {
        ShortestDistanceToCharacter obj = new ShortestDistanceToCharacter();
        String s = "loveleetcode";
        char c = 'e';
        int[] ans = obj.shortestToChar(s, c);
        System.out.println(Arrays.toString(ans));
    }

}
