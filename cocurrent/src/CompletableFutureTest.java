import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);

        completableFuture
                .thenAccept(result -> System.out.println("price:" + result))
                .exceptionally(exception -> {
                    System.out.println("failed");
                    return null;
                });

        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed");
        }
        return 5 + Math.random() * 20;
    }
}
