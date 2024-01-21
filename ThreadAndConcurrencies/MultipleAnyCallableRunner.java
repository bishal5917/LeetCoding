package ThreadAndConcurrencies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Note that if we want a thread to just run and do something we use Runnable
//Note that if we want a thread to do something and return values we use Callable

public class MultipleAnyCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<CallableTask> tasks = new ArrayList<>();
        tasks.add(new CallableTask("Stacks"));
        tasks.add(new CallableTask("Queues"));
        tasks.add(new CallableTask("Heaps"));
        ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());
        //We are looking at invokeAny method
        //if we want to execute a number of tasks and return the value returned by the task
        //whichever one completes initially,we use invokeAny
        String returned = executorService.invokeAny(tasks);
        System.out.println(returned);
        System.out.println("Main method ended");
        // Always do shutdown otherwise your program will keep on running
        executorService.shutdown();
    }
}
