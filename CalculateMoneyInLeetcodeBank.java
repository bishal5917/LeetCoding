public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int money = 0;
        int monday = 1;
        int curr = 1;
        while (n > 0) {
            // Lets go for one week
            for (int i = 0; i < 7; i++) {
                if (n == 0) {
                    break;
                }
                n--;
                money += curr++;
            }
            // After one week is over, we gotta reset value for next week
            monday++;
            curr = monday;
        }
        return money;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank obj = new CalculateMoneyInLeetcodeBank();
        int n = 10;
        System.out.println(obj.totalMoney(n));
    }
}
