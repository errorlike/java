public class AccessLimitControlTest {
    // 执行过程应该是3个一组的
    public static void main(String[] args) {
        AccessLimitControl accessLimitControl = new AccessLimitControl();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                String access = null;
                try {
                    access = accessLimitControl.access();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("access " + access);
            });
            thread.start();
        }
    }
}
