public class Semaphore {
    private int value;

    public Semaphore(int initial) {
        this.value = initial;
    }



    //decrements semaphore value and gives process access to the resource
    //
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
