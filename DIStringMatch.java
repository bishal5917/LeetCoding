import java.util.Arrays;

public class DIStringMatch {

    public int[] diStringMatch(String s) {
        int[] perm = new int[s.length() + 1];
        int i = 0;
        int j = s.length();
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == 'I') {
                perm[idx] = i;
                i += 1;
            } else {
                perm[idx] = j;
                j -= 1;
            }
        }
        // now add i at last
        perm[s.length()] = i;
        return perm;
    }

    public static void main(String[] args) {
        DIStringMatch obj = new DIStringMatch();
        String s = "IDID";
        int[] ans = obj.diStringMatch(s);
        System.out.println(Arrays.toString(ans));
    }
}
