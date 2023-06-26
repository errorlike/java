import java.util.UUID;
import java.util.concurrent.Semaphore;

/**
 * AccessLimitControl
 */
public class AccessLimitControl {

    private final Semaphore semaphore = new Semaphore(3);

    public String access() throws InterruptedException {
        semaphore.acquire();
        try {
            Thread.sleep(1000L);
            return UUID.randomUUID().toString();
        } finally {
            semaphore.release();
        }
    }

}