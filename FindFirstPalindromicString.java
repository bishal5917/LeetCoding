public class FindFirstPalindromicString {

    public String firstPalindrome(String[] words) {
        // Lets just iterate and return the first palindromic string
        for (String word : words) {
            if (isPalindromicString(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindromicString(String word) {
        int l = 0;
        int r = word.length() - 1;
        while (l <= r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        FindFirstPalindromicString obj = new FindFirstPalindromicString();
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println(obj.firstPalindrome(words));
    }

}
