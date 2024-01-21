package ThreadAndConcurrencies;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Note that if we want a thread to just run and do something we use Runnable
//Note that if we want a thread to do something and return values we use Callable

class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }

}

public class CallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // newFixedThreadPool means only 3 threads can be active at one point at a time
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> returned = executorService.submit(new CallableTask("Bsal"));
        // get method will wait for a task to get completed,after completing,it then
        // moves to a new line
        String msg = returned.get();
        System.out.println(msg);
        System.out.println("Main method ended");
        // Always do shutdown otherwise your program will keep on running
        executorService.shutdown();
    }
}
