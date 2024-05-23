import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {

    boolean isAdditive = false;

    public boolean isAdditiveNumber(String num) {
        generateNumsHelper(num, new ArrayList<>(), 0);
        return isAdditive;
    }

    private List<BigInteger> generateNumsHelper(String num, List<BigInteger> curr, int st) {
        if (isAdditive) {
            return curr;
        }
        if (st >= num.length()) {
            // means one swoop done,return
            if (curr.size() >= 3 && isAdditive(curr)) {
                isAdditive = true;
                System.out.println(curr);
            }
            return curr;
        }
        for (int i = 1; i <= num.length(); i++) {
            if (st + i > num.length()) {
                continue;
            }
            String str = num.substring(st, st + i);
            if (str.startsWith("0") && str.length() > 1) {
                continue;
            }
            BigInteger val = new BigInteger(str);
            curr.add(val);
            curr = generateNumsHelper(num, curr, st + i);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private boolean isAdditive(List<BigInteger> curr) {
        for (int i = 0; i < curr.size() - 2; i++) {
            if (!curr.get(i).add(curr.get(i + 1)).equals(curr.get(i + 2))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AdditiveNumber obj = new AdditiveNumber();
        String num = "199100199";
        System.out.println(obj.isAdditiveNumber(num));
    }
}
