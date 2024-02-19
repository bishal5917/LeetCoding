import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        // Lets keep track of how many tasks we have of each difficulty level
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int task : tasks) {
            if (bucket.get(task) == null) {
                bucket.put(task, 1);
            } else {
                int count = bucket.get(task);
                bucket.put(task, count + 1);
            }
        }

        // Now lets iterate over the map and count the total rounds
        int rounds = 0;
        int completed = 0;
        // means we will loop till we complete all the rounds
        while (completed != tasks.length) {
            for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
                if (bucket.get(entry.getKey()) == 1) {
                    // means we cant complete the task
                    return -1;
                }
                if (bucket.get(entry.getKey()) == 0) {
                    // means that task is done,just continue
                    continue;
                }
                if (bucket.get(entry.getKey()) % 3 == 0) {
                    // get the previous
                    int prev = bucket.get(entry.getKey());
                    // update the previous by decrementing it from 3,as 3 is the max task we can
                    // complete
                    bucket.put(entry.getKey(), prev - 3);
                    // add 3 to the completed
                    completed += 3;
                    // increase the rounds by 1
                    rounds += 1;
                } else {
                    // else we can just make a group of 2 at max to complete the task
                    // get the previous
                    int prev = bucket.get(entry.getKey());
                    // update the previous by decrementing it from 2,as 2 is the max task we can
                    // complete in this case
                    bucket.put(entry.getKey(), prev - 2);
                    // add 3 to the completed
                    completed += 2;
                    // increase the rounds by 1
                    rounds += 1;
                }
            }
        }
        return rounds;
    }

    public static void main(String[] args) {
        int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
        // int[] tasks = { 5, 5, 5, 5 };
        MinimumRoundsToCompleteAllTasks obj = new MinimumRoundsToCompleteAllTasks();
        System.out.println(obj.minimumRounds(tasks));
    }

}
