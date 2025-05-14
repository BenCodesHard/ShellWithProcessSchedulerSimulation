public class Semaphore {
    private int value;

    public Semaphore(int initial) {
        this.value = initial;
    }

    public synchronized void waitSem() throws InterruptedException {
        while (value <= 0) {
            wait();
        }
        value--;
    }

    public synchronized void signal() {
        value++;
        notify();
    }

    public synchronized int getValue() {
        return value;
    }
}
