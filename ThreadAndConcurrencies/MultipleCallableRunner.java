package ThreadAndConcurrencies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Note that if we want a thread to just run and do something we use Runnable
//Note that if we want a thread to do something and return values we use Callable

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<CallableTask> tasks = new ArrayList<>();
        tasks.add(new CallableTask("Stacks"));
        tasks.add(new CallableTask("Queues"));
        tasks.add(new CallableTask("Heaps"));
        ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());
        List<Future<String>> returned = executorService.invokeAll(tasks);
        for (Future<String> msg : returned){
            System.out.println(msg.get());
        }
        System.out.println("Main method ended");
        // Always do shutdown otherwise your program will keep on running
        executorService.shutdown();
    }
}
