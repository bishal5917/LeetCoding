public class CapacityToShipPackagesWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        int minOne = Integer.MAX_VALUE;
        // So we gotta find the lower bound and upper bound for checking
        int sum = 0;
        // Lets find the sum of all the ships
        for (int weight : weights) {
            sum += weight;
        }
        int l = weights[weights.length - 1];
        int r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            // we check if its valid here
            if (isValid(weights, mid, days)) {
                minOne = Math.min(minOne, mid);
                // Now we try to find even smaller
                r = mid - 1;
            } else {
                // we are obliged to increase
                l = mid + 1;
            }
        }
        return minOne;
    }

    private boolean isValid(int[] weights, int capacity, int days) {
        int shipsTaken = 0;
        int idx = 0;
        // Lets check if we can ship all on capacity ships within days
        while (idx < weights.length) {
            int curr = 0;
            while (idx < weights.length && (curr + weights[idx]) <= capacity) {
                curr += weights[idx++];
            }
            shipsTaken++;
            if (shipsTaken > days) {
                // if exceeds return false directly
                return false;
            }
        }
        return shipsTaken <= days;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDays obj = new CapacityToShipPackagesWithinDays();
        int[] weights = { 1, 2, 3, 1, 1 };
        int days = 4;
        System.out.println(obj.shipWithinDays(weights, days));
    }
}
