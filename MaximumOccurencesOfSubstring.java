import java.util.HashMap;

public class MaximumOccurencesOfSubstring {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int currMaxOccurence = 0;
        if (s.length() < minSize)
            return currMaxOccurence;
        int i = 0;
        int j = 0;
        StringBuilder curr = new StringBuilder();
        // maintain a HashMap to count
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        // first maintain a window of size minsize
        while (j < minSize) {
            char currChar = s.charAt(j);
            curr.append(currChar);
            // add to charmap
            if (charMap.get(currChar) == null) {
                charMap.put(currChar, 1);
            } else {
                charMap.put(currChar, charMap.get(currChar) + 1);
            }
            j += 1;
        }
        if (charMap.size() <= maxLetters) {
            map.put(curr.toString(), 1);
            currMaxOccurence = 1;
        }
        // NOW LETS SLIDE THE WINDOW WHILE CHECKING
        while (i < s.length() && j < s.length()) {
            char prevChar = s.charAt(i);
            char nextChar = s.charAt(j);
            curr.deleteCharAt(0);
            curr.append(nextChar);
            // remove the prev char
            if (charMap.get(prevChar) == 1) {
                charMap.remove(prevChar);
            } else {
                charMap.put(prevChar, charMap.get(prevChar) - 1);
            }
            // add the next char
            if (charMap.get(nextChar) == null) {
                charMap.put(nextChar, 1);
            } else {
                charMap.put(nextChar, charMap.get(nextChar) + 1);
            }
            // Now check
            if (charMap.size() <= maxLetters) {
                if (map.containsKey(curr.toString())) {
                    int prev = map.get(curr.toString());
                    map.put(curr.toString(), prev + 1);
                    currMaxOccurence = Math.max(currMaxOccurence, prev + 1);
                } else {
                    map.put(curr.toString(), 1);
                    currMaxOccurence = Math.max(currMaxOccurence, 1);
                }
            }
            i += 1;
            j += 1;
        }
        System.out.println(map);
        return currMaxOccurence;
    }

    public static void main(String[] args) {
        MaximumOccurencesOfSubstring obj = new MaximumOccurencesOfSubstring();
        String s = "aababcaab";
        System.out.println(obj.maxFreq(s, 2, 3, 4));
    }
}
