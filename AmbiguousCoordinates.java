import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        List<List<String>> strs = new ArrayList<>();
        generateCommaStringsHelper(s.substring(1, s.length() - 1), new ArrayList<>(), 0, strs);
        // System.out.println(strs);
        // Now time to generate comma strings for each one of them
        for (List<String> str : strs) {
            String a = str.get(0);
            String b = str.get(1);
            List<String> aList = new ArrayList<>();
            List<String> bList = new ArrayList<>();
            if (a.startsWith("0")) {
                if (a.length() == 1) {
                    aList.add(a);
                }
            } else {
                aList.add(a);
            }
            if (b.startsWith("0")) {
                if (b.length() == 1) {
                    bList.add(b);
                }
            } else {
                bList.add(b);
            }
            generatePointStringsHelper(a, new ArrayList<>(), 0, aList);
            generatePointStringsHelper(b, new ArrayList<>(), 0, bList);
            for (String i : aList) {
                StringBuilder currStr = new StringBuilder();
                for (String j : bList) {
                    currStr.append("(");
                    currStr.append(i);
                    currStr.append(",");
                    currStr.append(" ");
                    currStr.append(j);
                    currStr.append(")");
                    ans.add(currStr.toString());
                    currStr = new StringBuilder();
                }
            }
        }
        return ans;
    }

    private List<String> generateCommaStringsHelper(String s, List<String> curr, int st, List<List<String>> strs) {
        if (st >= s.length()) {
            if (curr.size() == 2) {
                strs.add(new ArrayList<>(curr));
            }
            return curr;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (st + i > s.length()) {
                continue;
            }
            String str = s.substring(st, st + i);
            curr.add(str);
            curr = generateCommaStringsHelper(s, curr, st + i, strs);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private List<String> generatePointStringsHelper(String s, List<String> curr, int st, List<String> strs) {
        if (st >= s.length()) {
            if (curr.size() == 2) {
                if (checkValidWithZero(curr)) {
                    strs.add(String.join(".", curr));
                }
            }
            return curr;
        }
        for (int i = 1; i < s.length(); i++) {
            if (st + i > s.length()) {
                continue;
            }
            String str = s.substring(st, st + i);
            if (str.length() > 1 && Integer.parseInt(str) == 0) {
                continue;
            }
            curr.add(str);
            curr = generatePointStringsHelper(s, curr, st + i, strs);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private boolean checkValidWithZero(List<String> curr) {
        String a = curr.get(0);
        String b = curr.get(1);
        if (a.equals("0") && a.equals(b)) {
            return false;
        }
        if (a.startsWith("0") && a.length() > 1) {
            return false;
        }
        if (b.equals("0")) {
            return false;
        }
        if (b.endsWith("0")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates obj = new AmbiguousCoordinates();
        String s = "(0123)";
        System.out.println(obj.ambiguousCoordinates(s));
    }
}
