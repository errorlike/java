public class TaskQueueWithConditionTest {
    public static void main(String[] args) throws InterruptedException {
        TaskQueueWithCondition taskQueue = new TaskQueueWithCondition();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                String task = null;
                try {
                    task = taskQueue.getTask();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get task" + task);
            });
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                String task = "task-" + (int) (Math.random() * 10);
                System.out.println(task);
                taskQueue.addTask(task);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
