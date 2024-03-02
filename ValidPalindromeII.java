public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        return validPalindromeRecursiveHelper(0, s.length() - 1, s, false);
    }

    private boolean validPalindromeRecursiveHelper(int l, int r, String s, boolean hasRemoved) {
        if (l > r) {
            return true;
        }
        if (s.charAt(l) == s.charAt(r)) {
            return validPalindromeRecursiveHelper(l + 1, r - 1, s, hasRemoved);
        } else {
            if (!hasRemoved) {
                boolean leftRemoved = validPalindromeRecursiveHelper(l + 1, r, s, true);
                boolean rightRemoved = validPalindromeRecursiveHelper(l, r - 1, s, true);
                return leftRemoved || rightRemoved;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ValidPalindromeII obj = new ValidPalindromeII();
        String s = "abca";
        System.out.println(obj.validPalindrome(s));
    }
}