// 创建两个进程，一个进程负责加，另一个进程负责减
public class App {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.inc();
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.dec();
            }
        });

        incThread.start();
        decThread.start();

        //主线程等待
        incThread.join();
        decThread.join();

        System.out.println(counter.get());


    }
}
