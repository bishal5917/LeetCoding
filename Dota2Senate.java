import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        // We use two queues
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        // Now gotta add respective indices to queue
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }
        // Now time to compete
        while (!rq.isEmpty() && !dq.isEmpty()) {
            int r = rq.poll();
            int d = dq.poll();
            if (r < d) {
                rq.offer(n++);
            } else {
                dq.offer(n++);
            }
        }
        if (rq.isEmpty()) {
            return "Dire";
        }
        return "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate obj = new Dota2Senate();
        String senate = "RDD";
        System.out.println(obj.predictPartyVictory(senate));
    }
}
