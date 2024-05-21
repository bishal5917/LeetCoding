import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartitionHelper(s, new ArrayList<>(), ans, 0);
        return ans;
    }

    private List<String> palindromePartitionHelper(String s, List<String> curr, List<List<String>> ans, int st) {
        if (st >= s.length()) {
            ans.add(new ArrayList<>(curr));
            return curr;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (st + i > s.length()) {
                continue;
            }
            String splitted = s.substring(st, st + i);
            if (isPalindrome(splitted)) {
                curr.add(splitted);
                curr = palindromePartitionHelper(s, curr, ans, st + i);
                curr.remove(curr.size() - 1);
            }
        }
        return curr;
    }

    private boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String s = "aab";
        System.out.println(obj.partition(s));
    }
}
