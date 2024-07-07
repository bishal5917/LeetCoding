public class SplitIntoBalancedStrings {

    public int balancedStringSplit(String s) {
        int count = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l += 1;
            } else {
                r += 1;
            }
            if (l == r && l != 0 && r != 0) {
                count += 1;
                l = 0;
                r = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SplitIntoBalancedStrings obj = new SplitIntoBalancedStrings();
        String s = "RLRRLLRLRL";
        System.out.println(obj.balancedStringSplit(s));
    }
}