public class LongestChunkedPalindromicDecomposition {

    public int longestDecomposition(String text) {
        int n = text.length();
        int count = 0;
        // Lets just use a two pointer technique
        int i = 0;
        int j = n - 1;
        int len = 1;
        while (i < j) {
            while (i + len <= j &&
                    !text.substring(i, i + len).equals(text.substring(j - len + 1, j + 1))) {
                len += 1;
            }
            if (i + len > j) {
                break;
            }
            // else equals found,increase the count
            count += 2;
            i += len;
            j -= len;
            len = 1;
        }
        if (i <= j)
            count += 1;
        return count;
    }

    public static void main(String[] args) {
        LongestChunkedPalindromicDecomposition obj = new LongestChunkedPalindromicDecomposition();
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        System.out.println(obj.longestDecomposition(text));
    }
}
