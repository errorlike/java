import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * MakeTea
 */
public class MakeTea {
    public static void main(String[] args) {
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶");
            try {
                TimeUnit.SECONDS.sleep(1l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2:洗茶杯");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2:拿茶叶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "龙井";
        });
        CompletableFuture<String> task3 = task1.thenCombine(task2, (__, task2Result) -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "泡茶";
        });
        System.out.println(task3.join());
    }
}