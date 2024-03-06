public class MinimumStringLengthAfterDeletingBothEnds {

    public int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;
        // Lets iterate using two pointers
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                // now remove till we find the same from both ends
                char currChar = s.charAt(i);
                while (i <= j && s.charAt(i) == currChar) {
                    i += 1;
                }
                while (i <= j && s.charAt(j) == currChar) {
                    j -= 1;
                }
            } else {
                // else just break out
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
        return j - i + 1;
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterDeletingBothEnds obj = new MinimumStringLengthAfterDeletingBothEnds();
        String s = "cabaabac";
        System.out.println(obj.minimumLength(s));
    }
}
