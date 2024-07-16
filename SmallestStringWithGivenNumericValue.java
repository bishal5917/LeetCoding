
public class SmallestStringWithGivenNumericValue {

    public String getSmallestString(int n, int k) {
        StringBuilder str = new StringBuilder();
        // Now we try to create a string with all ones
        for (int i = 0; i < n; i++) {
            str.append('a');
        }
        // We process from the last
        int currSum = n;
        for (int j = n - 1; j >= 0; j--) {
            int diff = k - currSum;
            // minimum between 25 and diff
            diff = Math.min(25, diff);
            if (diff <= 0) {
                break;
            }
            currSum += diff;
            str.setCharAt(j, (char) ('a' + diff));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        SmallestStringWithGivenNumericValue obj = new SmallestStringWithGivenNumericValue();
        int n = 5;
        int k = 73;
        System.out.println(obj.getSmallestString(n, k));
    }
}
