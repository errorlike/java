public class Counter {
    private int value = 0;

    public  int get() {
        return value;
    }

    public synchronized void inc() {
        value++;
    }

    public synchronized void dec() {
        value--;
    }
}
