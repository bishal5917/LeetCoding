package ThreadAndConcurrencies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // newFixedThreadPool means only 3 threads can be active at one point at a time
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        // Last of main method
        System.out.println("Main method ended");
        // Always do shutdown otherwise your program will keep on running
        executorService.shutdown();
    }
}
