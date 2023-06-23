public class PointStampedLockTest {
    public static void main(String[] args) {
        Point point = new Point();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                point.move(1, 1);
            });
            thread.start();
        }
        Thread changeThread = new Thread(() -> {
            System.out.println(point.distanceFromOrigin());
        });
        changeThread.start();
    }
}
