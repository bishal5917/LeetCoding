public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        StringBuilder sbr = new StringBuilder();
        // Let's count the ones and zeroes
        int ones = 0;
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                zeros++;
            }
        }
        while (ones > 1) {
            sbr.append("1");
            ones--;
        }
        while (zeros > 0) {
            sbr.append("0");
            zeros--;
        }
        sbr.append("1");
        return sbr.toString();
    }

    public static void main(String[] args) {
        MaximumOddBinaryNumber obj = new MaximumOddBinaryNumber();
        String s = "0101";
        System.out.println(obj.maximumOddBinaryNumber(s));
    }
}
