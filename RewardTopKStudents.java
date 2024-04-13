import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class RewardTopKStudents {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        List<Integer> topStds = new ArrayList<>();
        HashSet<String> pset = new HashSet<>();
        HashSet<String> nset = new HashSet<>();
        for (String str : positive_feedback) {
            pset.add(str);
        }
        for (String str : negative_feedback) {
            nset.add(str);
        }
        // Basically just find the scores and put in a priority queue with ids
        // and poll k top and just return
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);
        // Now go for every reports
        for (int i = 0; i < report.length; i++) {
            int currScore = 0;
            String[] curr = report[i].split(" ");
            for (String feedback : curr) {
                if (pset.contains(feedback)) {
                    currScore += 3;
                }
                if (nset.contains(feedback)) {
                    currScore -= 1;
                }
            }
            pq.offer(new int[] { student_id[i], currScore });
        }
        System.out.println(pq);
        // now pop top k and return
        while (k > 0 && !pq.isEmpty()) {
            int[] student = pq.poll();
            topStds.add((int) student[0]);
            k -= 1;
        }
        return topStds;
    }

    public static void main(String[] args) {
        RewardTopKStudents obj = new RewardTopKStudents();
        String[] pf = { "smart", "brilliant", "studious" };
        String[] nf = { "not" };
        String[] report = { "this student is studious", "the student is smart" };
        int[] ids = { 1, 2 };
        int k = 2;
        System.out.println(obj.topStudents(pf, nf, report, ids, k));
    }
}
