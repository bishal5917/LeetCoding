package BigDataProcessing;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ReduceCallable implements Callable<Map.Entry<String, Integer>> {

    public final String metricName;
    public final List<Integer> metricCounts;

    public ReduceCallable(String metricName, List<Integer> metricCounts) {
        this.metricName = metricName;
        this.metricCounts = metricCounts;
    }

    @Override
    public Map.Entry<String, Integer> call() throws Exception {
        int total = 0;
        for (Integer metricCount : metricCounts) {
            total += metricCount;
        }
        return new AbstractMap.SimpleEntry<>(this.metricName, total);
    }

}