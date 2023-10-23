package myConcurrencyExample.gonka;

public class DecrementThread extends ChangeCountThread {
    public DecrementThread(String threadName, Count count) {
        super(threadName, count, -1);
    }
}
