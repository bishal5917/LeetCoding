package ConcurrencyAndAtomicOperations;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLock {

    private int i = 0;
    private int j = 0;

    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();

    // This keyword means that the method is synchronized at the method
    // level. When a method is declared as synchronized, it means that only one
    // thread can execute that method at a time for the same instance of the class.
    // It provides a form of mutual exclusion, preventing multiple threads from
    // interfering with each other while accessing or modifying shared data.
    public synchronized void incrementI() {
        lockForI.lock();
        i += 1;
        lockForI.unlock();
    }

    public synchronized void incrementJ() {
        lockForJ.lock();
        j += 1;
        lockForJ.unlock();
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
