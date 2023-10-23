package myConcurrencyExample.lock;

/* A thread that transfers money from an account to other
   accounts in a bank.
 */
public class TransferThread extends Thread {
    private Bank bank;
    private int fromAccount;
    private int maxAmount;

    /**
     * Constructs a transfer thread.
     *
     * @param b    the bank between whose account money is transferred
     * @param from the account to transfer money from
     * @param max  the maximum amount of money in each transfer
     */
    public TransferThread(Bank b, int from, int max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run() {
        try {
            while (!interrupted()) {
                int toAccount = (int) (bank.size() * Math.random());
                int amount = (int) (maxAmount * Math.random());
                bank.transferWithCondition(fromAccount, toAccount, amount);
                sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
}
