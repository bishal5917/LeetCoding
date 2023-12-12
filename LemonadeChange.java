import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> pocket = new HashMap<>();
        pocket.put(5, 0);
        pocket.put(10, 0);
        for (int i = 0; i < bills.length; i++) {
            System.out.println(pocket);
            if (bills[i] == 5) {
                int val = pocket.get(5);
                val = val + 1;
                pocket.put(5, val);
            } else if (bills[i] == 10) {
                // add 10 to pocket and give 5 to the customer
                int val = pocket.get(10);
                val = val + 1;
                pocket.put(10, val);
                int fiveVal = pocket.get(5);
                fiveVal = fiveVal - 1;
                if (fiveVal < 0) {
                    return false;
                }
                pocket.put(5, fiveVal);
            } else if (bills[i] == 20) {
                int fiveVal = pocket.get(5);
                int tenVal = pocket.get(10);
                if (fiveVal >= 1 && tenVal >= 1) {
                    tenVal = tenVal - 1;
                    fiveVal = fiveVal - 1;
                    pocket.put(5, fiveVal);
                    pocket.put(10, tenVal);
                } else if (fiveVal >= 3) {
                    fiveVal = fiveVal - 3;
                    pocket.put(5, fiveVal);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange obj = new LemonadeChange();
        int[] bills = { 5, 5, 5, 10, 20 };
        Boolean ans = obj.lemonadeChange(bills);
        System.out.println(ans);
    }
}