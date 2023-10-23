package myConcurrencyExample.gonka;

public class IncrementThread extends ChangeCountThread {
    public IncrementThread(String threadName, Count count) {
        super(threadName, count, 1);
    }
}
