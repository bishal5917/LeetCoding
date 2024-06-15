import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        // offer all idxs to the queue
        for (int i = 0; i < n; i++) {
            q.offer(new int[] { i, tickets[i] });
        }
        while (!q.isEmpty()) {
            // get remaining tickets at that pos
            time += 1;
            int[] curr = q.poll();
            int idx = curr[0];
            int ticket = curr[1];
            ticket -= 1;
            if (ticket == 0 && idx == k) {
                // means it got all tickets,return
                return time;
            }
            // now add back to the queue if all tickets arenot bought yet
            if (ticket != 0) {
                q.offer(new int[] { idx, ticket });
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TimeNeededToBuyTickets obj = new TimeNeededToBuyTickets();
        int[] tickets = { 2, 3, 2 };
        int k = 2;
        System.out.println(obj.timeRequiredToBuy(tickets, k));
    }

}
