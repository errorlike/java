//一组线程负责读
//一个线程负责写
public class ReadWriteLockTest {
    public static void main(String[] args) throws InterruptedException {
        CounterWithReadWriteLock counterWithReadWriteLock = new CounterWithReadWriteLock();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int[] arrays = counterWithReadWriteLock.get();
                for (int j = 0; j < arrays.length; j++) {
                    System.out.print(arrays[j]);
                }
                System.out.println();
                System.out.println("--------");

            });
            thread.start();
        }
        Thread incThread = new Thread(() -> {
            counterWithReadWriteLock.inc(0);
            System.out.println("add");
        });
        incThread.start();
    }

}
