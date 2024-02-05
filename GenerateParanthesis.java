import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        return findParanthesisHelper(new ArrayList<>(), "", 0, 0, n);
    }

    private List<String> findParanthesisHelper(List<String> paranths, String curr, int open, int closed, int n) {
        // BASE CASE
        if (curr.length() == n * 2) {
            paranths.add(curr);
            return paranths;
        }
        // EXPLORE ALL POSSIBILITIES
        if (open < n) {
            findParanthesisHelper(paranths, curr + '(', open + 1, closed, n);
        }
        if (open > closed) {
            findParanthesisHelper(paranths, curr + ')', open, closed + 1, n);
        }
        return paranths;
    }

    public static void main(String[] args) {
        GenerateParanthesis obj = new GenerateParanthesis();
        int n = 3;
        List<String> ans = obj.generateParenthesis(n);
        System.out.println(ans);
    }

}