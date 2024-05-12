import java.util.HashMap;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        // Lets count each of occurences in stones
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : stones.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        System.out.println(map);
        // Lets count now
        for (char c : jewels.toCharArray()) {
            if (!map.containsKey(c)) {
                continue;
            }
            count += map.get(c);
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones obj = new JewelsAndStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(obj.numJewelsInStones(jewels, stones));
    }
}
