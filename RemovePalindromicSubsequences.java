public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        // if its a palindrome,ans = 1,else 2,HAHA
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        RemovePalindromicSubsequences obj = new RemovePalindromicSubsequences();
        String s = "baabb";
        System.out.println(obj.removePalindromeSub(s));
    }

}
