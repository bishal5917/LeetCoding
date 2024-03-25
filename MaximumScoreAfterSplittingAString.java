public class MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
        int currentMax = 0;
        // count zeroes and ones
        int zeroes = 0;
        int ones = 0;
        if (s.charAt(0) == '0') {
            zeroes += 1;
        }
        // Now go for i=1 to last counting ones
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones += 1;
            }
        }
        System.out.println(zeroes);
        System.out.println(ones);
        // Now lets iterate while maximizing the score
        for (int i = 1; i < s.length(); i++) {
            currentMax = Math.max(currentMax, ones + zeroes);
            char curr = s.charAt(i);
            if (curr == '0') {
                zeroes += 1;
            }
            if (curr == '1') {
                ones -= 1;
            }
        }
        return currentMax;
    }

    public static void main(String[] args) {
        MaximumScoreAfterSplittingAString obj = new MaximumScoreAfterSplittingAString();
        String s = "011101";
        System.out.println(obj.maxScore(s));
    }
}
