//乐观锁，在读操作的最后检查时候在读的过程中进行了写操作，如果有的话，就再进行读取。

import java.util.concurrent.locks.StampedLock;

public class Point {
    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        // 并没有枷锁
        long stamp = stampedLock.tryOptimisticRead();

        if (stampedLock.validate(stamp)) {
            // 加锁操作
            long readLock = stampedLock.readLock();
            try {
                return Math.sqrt(x * x + y * y);
            } finally {
                stampedLock.unlockRead(readLock);
            }
        }
        return Math.sqrt(x * x + y * y);
    }
}
