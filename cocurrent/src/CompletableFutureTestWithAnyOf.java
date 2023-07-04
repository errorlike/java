import java.util.concurrent.CompletableFuture;

public class CompletableFutureTestWithAnyOf {
    public static void main(String[] args) {
        CompletableFuture<String> completableFutureFetchCodefromXinlang = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> completableFutureFetchCodeFromWangyi = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<Object> completableFutureFetchCode = CompletableFuture
                .anyOf(completableFutureFetchCodefromXinlang, completableFutureFetchCodeFromWangyi);

        CompletableFuture<Double> completableFutureFetchPricefromXinlang = completableFutureFetchCode
                .thenApplyAsync((code) -> {
                    return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
                });
        CompletableFuture<Double> completableFutureFetchPricefromWangyi = completableFutureFetchCode
                .thenApplyAsync((code) -> {
                    return fetchPrice((String) code, "https://money.163.com/price/");
                });
        CompletableFuture<Object> completableFutureFetchPrice = CompletableFuture
                .anyOf(completableFutureFetchPricefromXinlang, completableFutureFetchPricefromWangyi);

        completableFutureFetchPrice.thenAccept((price) -> {
            System.out.println(price);
        });
        completableFutureFetchPrice.join();
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
