public class CounterWithLockTest {
    public static void main(String[] args) throws InterruptedException {
        CounterWithLock counterWithLock = new CounterWithLock();
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counterWithLock.inc();
            }
        });
        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counterWithLock.dec();
            }
        });
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(counterWithLock.get());
    }
}
