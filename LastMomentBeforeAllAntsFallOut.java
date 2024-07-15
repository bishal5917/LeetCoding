public class LastMomentBeforeAllAntsFallOut {

    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for (int position : left) {
            lastMoment = Math.max(lastMoment, position - 0);
        }
        for (int position : right) {
            lastMoment = Math.max(lastMoment, n - position);
        }
        return lastMoment;
    }

    public static void main(String[] args) {
        LastMomentBeforeAllAntsFallOut obj = new LastMomentBeforeAllAntsFallOut();
        int n = 4;
        int[] left = { 4, 3 };
        int[] right = { 0, 1 };
        System.out.println(obj.getLastMoment(n, left, right));
    }
}
