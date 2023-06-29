import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> task = () -> {
            Thread.sleep(1000L);
            return "hello";
        };
        Future<String> future = executorService.submit(task);
        executorService.submit(() -> {
            System.out.println("running");
        });
        String value;
        try {
            value = future.get();
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
