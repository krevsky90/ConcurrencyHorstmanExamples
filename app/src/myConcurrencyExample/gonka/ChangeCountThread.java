package myConcurrencyExample.gonka;

public abstract class ChangeCountThread extends Thread {
    private Count count;
    private int delta;

    public ChangeCountThread(String threadName, Count count) {
        this.count = count;
        setName(threadName);
    }

    public ChangeCountThread(String threadName, Count count, int delta) {
        this(threadName, count);
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread " + Thread.currentThread() + ", name = " + getName());
            count.setCount(count.getCount() + getDelta());
            count.print();
        }
    }
}
