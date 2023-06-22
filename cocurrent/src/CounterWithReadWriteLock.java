import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterWithReadWriteLock {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private int[] array = new int[10];

    public void inc(int index) {
        writeLock.lock();
        try {
            array[index]+=1;
        } finally {
            writeLock.unlock();
        }
    }

    public int[] get() {
        readLock.lock();
        try {
            return Arrays.copyOf(array, array.length);
        } finally {
            readLock.unlock();

        }
    }
}
