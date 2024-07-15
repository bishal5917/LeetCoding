import java.util.Arrays;
import java.util.Comparator;

class Bag {
    int max;
    int curr;

    public Bag(int max, int curr) {
        this.max = max;
        this.curr = curr;
    }
}

public class MaximumBagsWithFullCapacity {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int fullBags = 0;
        // Lets create an array of Bag
        Bag[] bags = new Bag[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            int totalCapacity = capacity[i];
            int currRocks = rocks[i];
            bags[i] = new Bag(totalCapacity, currRocks);
        }
        // Now we gotta sort the bags based on difference to make it full
        // Sort the bags array using the custom comparator
        Arrays.sort(bags, new Comparator<Bag>() {
            @Override
            public int compare(Bag a, Bag b) {
                return Integer.compare((a.max - a.curr), (b.max - b.curr));
            }
        });
        // Now time to count the full bags
        for (Bag bag : bags) {
            int required = bag.max - bag.curr;
            if (required <= additionalRocks) {
                // means it can be full
                additionalRocks -= required;
                fullBags++;
            } else {
                break;
            }
        }
        return fullBags;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacity obj = new MaximumBagsWithFullCapacity();
        int[] capacity = { 2, 3, 4, 5 };
        int[] rocks = { 1, 2, 4, 4 };
        int additionalRocks = 2;
        System.out.println(obj.maximumBags(capacity, rocks, additionalRocks));
    }
}
