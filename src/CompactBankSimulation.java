class BankAccount {
    private double balance;
    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
    }

    public synchronized void deposit(double amount) {
        double newBalance = balance + amount;
        try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }
}
public class CompactBankSimulation {

    public static void main(String[] args) throws InterruptedException {
        BankAccount sharedAccount = new BankAccount(0);

        Runnable depositTask = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedAccount.deposit(1);
            }
        };
        Thread thread1 = new Thread(depositTask);
        Thread thread2 = new Thread(depositTask);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Expected Final Balance: 2000.0");
        System.out.println("Actual Final Balance:   " + sharedAccount.getBalance());

        if(sharedAccount.getBalance() != 2000.0) {
            System.out.println("Race condition detected! Data is inconsistent.");
        } else {
            System.out.println("Success! Data is consistent.");
        }
    }
}
