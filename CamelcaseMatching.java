import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String str : queries) {
            boolean matched = checkMatching(str, pattern);
            ans.add(matched);
        }
        return ans;
    }

    private boolean checkMatching(String word, String pattern) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < pattern.length()) {
            char w = word.charAt(i);
            char p = pattern.charAt(j);
            if (Character.isUpperCase(w) && Character.isUpperCase(p)) {
                if (w != p) {
                    return false;
                } else {
                    i += 1;
                    j += 1;
                }
            } else if (Character.isUpperCase(w) && Character.isLowerCase(p)) {
                j += 1;
            } else if ((Character.isUpperCase(p) && Character.isLowerCase(w))) {
                i += 1;
            } else {
                if (w != p) {
                    i += 1;
                } else {
                    i += 1;
                    j += 1;
                }
            }
        }
        while (i < word.length()) {
            char w = word.charAt(i);
            if (Character.isUpperCase(w)) {
                return false;
            }
            i += 1;
        }
        while (j < pattern.length()) {
            char p = pattern.charAt(j);
            if (Character.isUpperCase(p)) {
                return false;
            }
            j += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        CamelcaseMatching obj = new CamelcaseMatching();
        String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
        String pattern = "FoBa";
        System.out.println(obj.camelMatch(queries, pattern));
    }
}
