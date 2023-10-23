package v2ch1.synchBankTest;

/**
 * A bank with a number of bank accounts.
 */
class Bank {
    public static final int NTEST = 10000;
    private final int[] accounts;
    private long ntransacts = 0;

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
    }

    /**
     * Transfers money from one account to another.
     *
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }

        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        notifyAll();
        if (ntransacts % NTEST == 0) {
            test();
        }
    }

    /**
     * Prints a test message to check the integrity
     * of this bank object.
     */
    public synchronized void test() {
        int sum = 0;

        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i];
        }

        System.out.println("Transactions:" + ntransacts + " Sum: " + sum);
    }

    /**
     * Gets the number of accounts in the bank.
     *
     * @return the number of accounts
     */
    public int size() {
        return accounts.length;
    }
}
