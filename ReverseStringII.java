public class ReverseStringII {

    public String reverseStr(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < s.length(); i = i + (2 * k)) {
            int l = i;
            int r = Math.min(i + k - 1, s.length() - 1);
            while (l < r) {
                swap(str, l++, r--);
            }
        }
        return str.toString();
    }

    private void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        ReverseStringII obj = new ReverseStringII();
        String s = "abcdefg";
        int k = 2;
        System.out.println(obj.reverseStr(s, k));
    }
}
