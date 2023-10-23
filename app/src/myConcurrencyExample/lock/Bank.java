package myConcurrencyExample.lock;

import javax.transaction.TransactionRequiredException;
import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank with a number of bank accounts.
 */
class Bank {
    public static final int NTEST = 10000;
    private final int[] accounts;
    private long ntransacts = 0;

    private Lock bankLock = new ReentrantLock();
    private Condition condition;

    /**
     * Constructs the bank.
     *
     * @param n              the number of accounts
     * @param initialBalance the initial balance
     *                       for each account
     */
    public Bank(int n, int initialBalance) {
        accounts = new int[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }

        ntransacts = 0;
        condition = bankLock.newCondition();
    }

    /**
     * Transfers money from one account to another.
     *
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public void transferWithReentrantLock(int from, int to, int amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                wait();
            }

            accounts[from] -= amount;
            accounts[to] += amount;
            ntransacts++;
            notifyAll();
            if (ntransacts % NTEST == 0) {
                System.out.println("Total balance: " + getTotalBalance());
            }
        } finally {
            bankLock.unlock();
        }

        List list = new LinkedList();
        ListIterator it = list.listIterator(5);
        Map<String, String> map = new HashMap<String, String>();

        getClass().getClassLoader();





    }

    public void transferWithCondition(int from, int to, int amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                condition.await();  //waiting for this condition (!= thread.wait())
            }

            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.println(amount + " from " + from + " to " + to);
            accounts[to] += amount;
            ntransacts++;
            System.out.println("Total balance: " + getTotalBalance());

            condition.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

   public double getTotalBalance() {
       bankLock.lock();
       try {
           double sum = 0;
           for(double a : accounts) {
               sum += a;
           }

           return sum;
       } finally {
           bankLock.unlock();
       }
   }

    public int size() {
        return accounts.length;
    }
}
