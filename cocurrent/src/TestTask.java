//一组线程负责 add task 
//另一组线程负责 get task 
//没有限制队列的size，所以负责添加的线程数少于负责get的
public class TestTask {

    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                String task;
                try {
                    task = taskQueue.getTask();
                    System.out.println("get task" + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
