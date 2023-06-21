import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueueWithCondition {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition = reentrantLock.newCondition();
    Queue<String> queue = new LinkedList<>();

    public void addTask(String task) {
        reentrantLock.lock();
        try {
            queue.add(task);
            condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            reentrantLock.unlock();
        }
    }
}