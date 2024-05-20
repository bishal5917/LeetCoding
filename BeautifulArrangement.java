
public class BeautifulArrangement {

    int count = 0;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        getPermutationsHelper(n, 1, used);
        return count;
    }

    private void getPermutationsHelper(int n, int pos, boolean[] used) {
        if (pos > n) {
            count += 1;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (pos % i == 0 || i % pos == 0)) {
                used[i] = true;
                pos += 1;
                getPermutationsHelper(n, pos, used);
                pos -= 1;
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement obj = new BeautifulArrangement();
        int n = 3;
        System.out.println(obj.countArrangement(n));
    }
}
