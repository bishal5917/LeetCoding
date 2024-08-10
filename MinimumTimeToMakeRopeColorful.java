public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int minTotalCost = 0;
        int idx = 0;
        while (idx < n) {
            int currMax = 0;
            int total = 0;
            char currChar = colors.charAt(idx);
            while (idx < n && colors.charAt(idx) == currChar) {
                currMax = Math.max(currMax, neededTime[idx]);
                total += neededTime[idx];
                idx++;
            }
            minTotalCost += (total - currMax);
        }
        return minTotalCost;
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful obj = new MinimumTimeToMakeRopeColorful();
        String colors = "abaac";
        int[] neededTime = { 1, 2, 3, 4, 5 };
        System.out.println(obj.minCost(colors, neededTime));
    }
}
