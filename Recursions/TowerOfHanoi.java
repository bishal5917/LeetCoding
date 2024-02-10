package Recursions;

class TowerOfHanoi {

    public void solve(int n) {
        solveTowerOfHanoiHelper(n, "A", "B", "C");
    }

    private void solveTowerOfHanoiHelper(int n, String source, String aux, String destination) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            return;
        }
        solveTowerOfHanoiHelper(n - 1, source, destination, aux);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        solveTowerOfHanoiHelper(n - 1, aux, source, destination);
    }

    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi obj = new TowerOfHanoi();
        obj.solve(n);
    }
}