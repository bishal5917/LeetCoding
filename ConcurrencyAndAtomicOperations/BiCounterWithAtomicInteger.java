package ConcurrencyAndAtomicOperations;

import java.util.concurrent.atomic.AtomicInteger;

public class BiCounterWithAtomicInteger {

    private AtomicInteger i = new AtomicInteger();
    private AtomicInteger j = new AtomicInteger();

    public synchronized void incrementI() {
        i.getAndIncrement();
    }

    public synchronized void incrementJ() {
        j.getAndIncrement();
    }

    public int getI() {
        return i.get();
    }

    public int getJ() {
        return j.get();
    }
}
