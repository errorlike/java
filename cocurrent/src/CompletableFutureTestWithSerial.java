import java.util.concurrent.CompletableFuture;

public class CompletableFutureTestWithSerial {

    public static void main(String[] args)  {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    return queryCode("bababa");
                }).thenApplyAsync((code) -> {
                    return fetchPrice(code);
                }).thenAccept((result) -> {
                    System.out.println("price" + result);
                });
        future.join();
    }

    private static String queryCode(String name) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "601857";
    }

    private static Double fetchPrice(String code) {

        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5 + Math.random() * 20;
    }
}