public class LexicographicallySmallestPalindrome {

    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        String[] str = new String[n];
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            char small = left;
            if (left != right) {
                small = getSmallChar(left, right);
            }
            str[l] = String.valueOf(small);
            str[r] = String.valueOf(small);
            l += 1;
            r -= 1;
        }
        return String.join("", str);
    }

    private char getSmallChar(char a, char b) {
        if (Character.compare(a, b) < 0) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        LexicographicallySmallestPalindrome obj = new LexicographicallySmallestPalindrome();
        String s = "egcfe";
        System.out.println(obj.makeSmallestPalindrome(s));
    }
}
