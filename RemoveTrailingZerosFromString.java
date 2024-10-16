public class RemoveTrailingZerosFromString {

    public String removeTrailingZeros(String num) {
        // Lets count from the last and check for index with last zeros
        int n = num.length();
        int idx = n;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                idx = i;
            } else {
                break;
            }
        }
        return num.substring(0, idx);
    }

    public static void main(String[] args) {
        RemoveTrailingZerosFromString obj = new RemoveTrailingZerosFromString();
        String num = "512301008";
        System.out.println(obj.removeTrailingZeros(num));
    }
}
