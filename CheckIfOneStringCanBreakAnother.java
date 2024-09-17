import java.util.Arrays;

public class CheckIfOneStringCanBreakAnother {

    public boolean checkIfCanBreak(String s1, String s2) {
        int aCount = 0;
        int bCount = 0;
        // we sort and check if one can break the other
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < s1.length(); i++) {
            if (str1[i] >= str2[i]) {
                aCount++;
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (str2[i] >= str1[i]) {
                bCount++;
            }
        }
        return aCount == s1.length() || bCount == s2.length();
    }

    public static void main(String[] args) {
        CheckIfOneStringCanBreakAnother obj = new CheckIfOneStringCanBreakAnother();
        String s1 = "abc";
        String s2 = "xya";
        System.out.println(obj.checkIfCanBreak(s1, s2));
    }
}
