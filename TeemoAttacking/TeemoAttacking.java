package TeemoAttacking;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        total += duration;
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        int[] timeseries = { 1, 2, 3, 4, 5 };
        int duration = 5;
        TeemoAttacking obj = new TeemoAttacking();
        obj.findPoisonedDuration(timeseries, duration);
    }
}
