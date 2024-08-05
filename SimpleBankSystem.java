import java.util.HashMap;

class SimpleBankSystem {

    // Using the hashmap
    HashMap<Integer, Long> store;
    int n = 0;

    public SimpleBankSystem(long[] balance) {
        this.store = new HashMap<>();
        this.n = balance.length;
        // put the account values in the store map
        for (int i = 0; i < balance.length; i++) {
            store.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        // we transfer money from acc1 to acc2, but this is possible if money is
        // available
        if (account1 > n || store.get(account1) < money || account2 > n) {
            return false;
        }
        store.put(account1, store.get(account1) - money);
        store.put(account2, store.get(account2) + money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > n) {
            return false;
        }
        store.put(account, store.get(account) + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > n || store.get(account) < money) {
            return false;
        }
        store.put(account, store.get(account) - money);
        return true;
    }

    public static void main(String[] args) {
        SimpleBankSystem bank = new SimpleBankSystem(new long[] { 10, 100, 20, 50, 30 });
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }
}
