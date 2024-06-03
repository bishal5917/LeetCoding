import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReplaceNonCoprimeNumsInArray {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        // we use stack
        Stack<Integer> st = new Stack<>();
        for (int num : nums) {
            st.push(num);
            // else we go till its not equal
            while (st.size() > 1 &&
                    gcd(st.peek(), st.get(st.size() - 2)) > 1) {
                // get last two nums and calculate lcm and replace
                int a = st.pop();
                int b = st.pop();
                int lcm = (int) (a / gcd(a, b) * (long) b);
                st.push(lcm);
            }
        }
        return new ArrayList<>(st);
    }

    public long gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        ReplaceNonCoprimeNumsInArray obj = new ReplaceNonCoprimeNumsInArray();
        int[] nums = { 31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561 };
        System.out.println(obj.replaceNonCoprimes(nums));
    }
}
