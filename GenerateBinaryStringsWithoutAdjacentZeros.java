import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros {

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        String[] bStrings = new String[] { "0", "1" };
        return generateStringsRecursiveHelper(ans, bStrings, new StringBuilder(), n);
    }

    private List<String> generateStringsRecursiveHelper(List<String> ans, String[] bStrings, StringBuilder curr,
            int n) {
        if (curr.length() >= n) {
            ans.add(curr.toString());
            return ans;
        }

        // else we have two possibilities
        // adding 0 and 1
        // we can add 0 only if prev one wasn't zero,hehe bro remember this
        for (String str : bStrings) {
            if (str.equals("0")) {
                // if prev one was also 0, we continue
                if (curr.length() > 0 && curr.charAt(curr.length() - 1) == '0') {
                    continue;
                }
            }
            curr.append(str);
            ans = generateStringsRecursiveHelper(ans, bStrings, curr, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateBinaryStringsWithoutAdjacentZeros obj = new GenerateBinaryStringsWithoutAdjacentZeros();
        int n = 8;
        System.out.println(obj.validStrings(n));
    }
}