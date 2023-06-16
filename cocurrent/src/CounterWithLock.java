
//创建可重入锁
//添加变量
//给变量添加一个addOne方法。
//使用try finally释放资源

import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private int value = 0;

    public int get() {
        try {
            reentrantLock.lock();
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void inc() {
        try {
            reentrantLock.lock();
            value++;
        } finally {
            reentrantLock.unlock();
        }

    }

    public void dec() {
        try{
            reentrantLock.lock();
            value--;
        }finally{
            reentrantLock.unlock();
        }
    }
}
