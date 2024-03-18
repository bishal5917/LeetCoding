public class MaximumNumOfVowelsInSubstring {

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currVowelCount = 0;
        // First lets maintain a sliding window of size k
        int i = 0;
        int j = 0;
        while (j < s.length() && j < k) {
            if (isVowel(s.charAt(j))) {
                currVowelCount += 1;
            }
            j += 1;
        }
        maxVowels = Math.max(currVowelCount, maxVowels);
        // NOW SLIDE THE WINDOW WHILE CHECKING
        while (i < s.length() && j < s.length()) {
            if (isVowel(s.charAt(i))) {
                currVowelCount -= 1;
            }
            if (isVowel(s.charAt(j))) {
                currVowelCount += 1;
            }
            i += 1;
            j += 1;
            maxVowels = Math.max(currVowelCount, maxVowels);
        }
        return maxVowels;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        MaximumNumOfVowelsInSubstring obj = new MaximumNumOfVowelsInSubstring();
        String s = "abciiidef";
        int k = 3;
        System.out.println(obj.maxVowels(s, k));
    }
}
