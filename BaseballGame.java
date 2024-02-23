
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();
        int totalSum = 0;
        for (String item : operations) {
            if (item.equals("C")) {
                scores.remove(scores.size() - 1);
            } else if (item.equals("D")) {
                int prev = scores.get(scores.size() - 1);
                scores.add(prev * 2);
            } else if (item.equals("+")) {
                int last = scores.get(scores.size() - 1);
                int secondLast = scores.get(scores.size() - 2);
                scores.add(last + secondLast);
            } else {
                int val = Integer.parseInt(item);
                scores.add(val);
            }
        }
        for (int item : scores) {
            totalSum += item;
        }
        System.out.println(totalSum);
        return totalSum;
    }

    public static void main(String[] args) {
        String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        BaseballGame obj = new BaseballGame();
        obj.calPoints(ops);
    }
}