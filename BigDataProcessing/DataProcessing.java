package BigDataProcessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DataProcessing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // MAP
        String[] filePaths = {
                "./BigDataProcessing/log_1.txt",
                "./BigDataProcessing/log_2.txt",
                "./BigDataProcessing/log_3.txt",
                "./BigDataProcessing/log_4.txt",
                "./BigDataProcessing/log_5.txt",
                "./BigDataProcessing/log_6.txt",
                "./BigDataProcessing/log_7.txt",
                "./BigDataProcessing/log_8.txt",
                "./BigDataProcessing/log_9.txt",
                "./BigDataProcessing/log_10.txt",
        };
        ExecutorService mapExecutor = Executors.newFixedThreadPool(10);
        List<Future<Map<String, Integer>>> futureList = new ArrayList<>();
        for (String filePath : filePaths) {
            MapCallable mapCallable = new MapCallable(filePath);
            Future<Map<String, Integer>> future = mapExecutor.submit(mapCallable);
            futureList.add(future);
        }
        mapExecutor.shutdown();
        mapExecutor.awaitTermination(1, TimeUnit.SECONDS);

        // SHUFFLE
        Map<String, List<Integer>> shuffledMetrics = new HashMap<>();
        for (Future<Map<String, Integer>> mapFuture : futureList) {
            Map<String, Integer> mappedMetrics = mapFuture.get();
            mappedMetrics.forEach((key, value) -> {
                List<Integer> metricCountList = shuffledMetrics.getOrDefault(key, new ArrayList<>());
                metricCountList.add(value);
                shuffledMetrics.put(key, metricCountList);
            });
        }

        // REDUCE
        ExecutorService reduceExecutor = Executors.newFixedThreadPool(3);
        List<Future<Map.Entry<String, Integer>>> futureReducerList = new ArrayList<>();
        shuffledMetrics.forEach((key, value) -> {
            ReduceCallable reduceCallable = new ReduceCallable(key, value);
            Future<Map.Entry<String, Integer>> futureReducer = reduceExecutor.submit(reduceCallable);
            futureReducerList.add(futureReducer);
        });
        reduceExecutor.shutdown();
        reduceExecutor.awaitTermination(1, TimeUnit.SECONDS);

        // GET RESULTS
        Map<String, Integer> resultMap = new HashMap<>();
        for (Future<Map.Entry<String, Integer>> futureEntry : futureReducerList) {
            Map.Entry<String, Integer> entry = futureEntry.get();
            resultMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(resultMap);
    }
}
