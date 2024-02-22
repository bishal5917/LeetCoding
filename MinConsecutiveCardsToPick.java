import java.util.HashMap;

public class MinConsecutiveCardsToPick {

    public int minimumCardPickup(int[] cards) {
        int size = Integer.MAX_VALUE;
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (bucket.get(cards[i]) == null) {
                // add the index
                bucket.put(cards[i], i);
            } else {
                // if found,track the current size
                int currSize = i - bucket.get(cards[i]) + 1;
                size = Math.min(size, currSize);
                // Update the new index
                bucket.put(cards[i], i);
            }
        }
        // If we didnt found any,gotta return -1
        return size == Integer.MAX_VALUE ? -1 : size;
    }

    public static void main(String[] args) {
        MinConsecutiveCardsToPick obj = new MinConsecutiveCardsToPick();
        int[] cards = { 3, 4, 2, 3, 4, 7 };
        System.out.println(obj.minimumCardPickup(cards));
    }

}
