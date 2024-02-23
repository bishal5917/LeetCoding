import java.util.HashMap;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        // lets just use a hashmap
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == null) {
                charMap.put(s.charAt(i), 1);
            } else {
                int prev = charMap.get(s.charAt(i));
                charMap.put(s.charAt(i), prev + 1);
            }
        }
        System.out.println(charMap);
        // Now just traverse the map to return index
        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();
        String s = "leetcode";
        System.out.println(obj.firstUniqChar(s));
    }

}
