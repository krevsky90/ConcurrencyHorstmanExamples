package myConcurrencyExample.gonka;

public class Gonka {
    public static void main(String[] args) {
        Count count = new Count(10);
        IncrementThread t1 = new IncrementThread("t1111111111", count);
        DecrementThread t2 = new DecrementThread("t2", count);

        t1.start();
        t2.start();
    }
}
