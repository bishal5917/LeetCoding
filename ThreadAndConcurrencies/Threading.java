package ThreadAndConcurrencies;

class Task extends Thread{
    int num;

    Task(int num){
        this.num=num;
    }
    public void run(){
        System.out.println("Task " + num + " Kicked off");
        for (int i=num*10;i<num*10+6;i++){
            System.out.println(i+"");
        }
        // When a thread invokes Thread.yield(), it essentially indicates that it is willing 
        // to give up its current time slice and allow other threads to execute. This can be useful in scenarios
        //  where you want to promote better cooperation and fairness among threads.
        // Thread.yield();
        System.out.println("Task "+num+" Done");
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 2 Kicked off");
        for (int i = 6; i < 11; i++) {
            System.out.println(i+"");
        }
        System.out.println("Task 2 Done");
    }
}

public class Threading {
    public static void main(String[] args) throws InterruptedException{
        Task task1= new Task(1);
        //Note that setting priority is just a request.They might get honoured or might not get honoured
        task1.setPriority(1);
        task1.start();
        Task2 task2Runnable = new Task2();
        Thread task2= new Thread(task2Runnable);
        task2.setPriority(2);
        task2.start();
        //Lets say that we want this last method to execute only when
        //first of the two tasks get completed
        //Join waits for the task to be completed before moving further down the code
        task1.join();
        task2.join();
        //Last Method
        System.out.println("Main method ended");
    }
}
