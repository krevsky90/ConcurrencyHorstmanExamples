package myConcurrencyExample.gonka;

public class Count {
    private int count;

    public Count() {
        this.count = 0;
    }

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void print() {
        System.out.println("count = " + count);
    }
}
