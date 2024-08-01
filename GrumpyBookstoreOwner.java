public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // Lets make him not grumpy for the max case
        // we gotta find the window with the max sum
        int l = 0;
        int r = 0;
        int maxUnsatisfied = 0;
        int currWindowUnsatisfied = 0;
        int satisfied = 0;
        int n = customers.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            // Gotta make a fixed window of size 3
            if (j < minutes) {
                while (j < minutes) {
                    // count the grumpys
                    if (grumpy[j] == 1) {
                        currWindowUnsatisfied += customers[j];
                    }
                    // count the satisfied
                    if (grumpy[j] == 0) {
                        satisfied += customers[j];
                    }
                    j++;
                }
            } else {
                // count the grumpys
                if (grumpy[j] == 1) {
                    currWindowUnsatisfied += customers[j];
                }
                // count the satisfied
                if (grumpy[j] == 0) {
                    satisfied += customers[j];
                }
                j++;
            }
            // Now that the window is maintained
            // update the maxSum
            if (currWindowUnsatisfied > maxUnsatisfied) {
                maxUnsatisfied = currWindowUnsatisfied;
                l = i;
                r = j;
            }
            // We shrink from the left
            if (grumpy[i] == 1) {
                currWindowUnsatisfied -= customers[i];
            }
            i++;
        }
        // Now it will not become grumpy from l to r
        // add all customers within that
        for (int idx = l; idx < r; idx++) {
            if (grumpy[idx] == 1) {
                satisfied += customers[idx];
            }
        }
        // System.out.println(maxSum + "-" + l + "-" + r);
        return satisfied;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner obj = new GrumpyBookstoreOwner();
        int[] customers = { 4, 10, 10 };
        int[] grumpy = { 1, 1, 0 };
        int minutes = 2;
        System.out.println(obj.maxSatisfied(customers, grumpy, minutes));
    }
}
