import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int time = 0;
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        // we process four tasks with a processor with a minTime and then go on
        int idx = 0;
        for (int processor : processorTime) {
            int maxOfFour = 0;
            // now process the first four
            for (int i = 0; i < 4; i++) {
                maxOfFour = Math.max(maxOfFour, processor + tasks.get(idx++));
            }
            time = Math.max(time, maxOfFour);
        }
        return time;
    }

    public static void main(String[] args) {
        MinimumProcessingTime obj = new MinimumProcessingTime();
        List<Integer> processorTime = new ArrayList<>(
                Arrays.asList(8, 10));
        List<Integer> tasks = new ArrayList<>(
                Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5));
        System.out.println(obj.minProcessingTime(processorTime, tasks));
    }
}
