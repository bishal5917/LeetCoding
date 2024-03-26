public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        // Now lets first count the prefix N and suffix Y
        int n = 0;
        int y = 0;
        int minPenalty = Integer.MAX_VALUE;
        int minPenaltyIdx = -1;
        // count the suffix y
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                y += 1;
            }
        }
        // Now lets calculate the penalty
        for (int i = 0; i < customers.length(); i++) {
            int penalty = n + y;
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minPenaltyIdx = i;
            }
            if (customers.charAt(i) == 'N') {
                n += 1;
            }
            if (customers.charAt(i) == 'Y') {
                y -= 1;
            }
        }
        System.out.println(n);
        System.out.println(y);
        // Now for the last index
        if (n + y < minPenalty) {
            minPenaltyIdx = customers.length();
        }
        return minPenaltyIdx;
    }

    public static void main(String[] args) {
        MinimumPenaltyForAShop obj = new MinimumPenaltyForAShop();
        String customers = "YYNY";
        System.out.println(obj.bestClosingTime(customers));
    }
}
