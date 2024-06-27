import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        // Declaring a queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(i);
        }
        // Sorting the deck
        Arrays.sort(deck);
        // Now simulate the process
        for (int i = 0; i < n; i++) {
            // we reveal the top one
            if (!q.isEmpty()) {
                int top = q.poll();
                ans[top] = deck[i];
            }
            // send second to bottom
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder obj = new RevealCardsInIncreasingOrder();
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
        int[] ans = obj.deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(ans));
    }
}
