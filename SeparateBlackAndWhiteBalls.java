public class SeparateBlackAndWhiteBalls {

    public long minimumSteps(String s) {
        long steps = 0;
        int last = s.length() - 1;
        int r = s.length() - 1;
        while (r >= 0) {
            if (s.charAt(r) == '1') {
                // calculate the steps and store
                steps = steps + last - r;
                // decrement the last coz (last gets secondlast and so on)
                last -= 1;
            }
            r -= 1;
        }
        return steps;
    }

    public static void main(String[] args) {
        SeparateBlackAndWhiteBalls obj = new SeparateBlackAndWhiteBalls();
        String s = "101";
        System.out.println(obj.minimumSteps(s));
    }
}
