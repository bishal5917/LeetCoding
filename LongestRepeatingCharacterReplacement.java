
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        // Lets find this for all english alphabets
        int max = 0;
        for (int i = 65; i <= 90; i++) {
            char ch = (char) i;
            int val = characterReplaceHelper(s, k, ch);
            max = Math.max(max, val);
        }
        return max;
    }

    private int characterReplaceHelper(String s, int k, char ch) {
        int i = 0;
        int j = 0;
        int currMax = 0;
        while (i < s.length() && j < s.length()) {
            if (s.charAt(j) == ch) {
                currMax = Math.max(currMax, j - i + 1);
                j += 1;
            } else {
                if (k <= 0) {
                    if (s.charAt(i) == ch) {
                        i += 1;
                    } else {
                        i += 1;
                        k += 1;
                    }
                } else {
                    currMax = Math.max(currMax, j - i + 1);
                    k -= 1;
                    j += 1;
                }
            }
        }
        return currMax;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        String s = "ABAB";
        int k = 2;
        System.out.println(obj.characterReplacement(s, k));
    }

}