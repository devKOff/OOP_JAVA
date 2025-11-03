import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BankLogic {
    // Logic Class: Account
    public static class Account {
        private String accountNumber;
        private String accountHolderName;
        private double balance;
        private int pin;

        public Account(String accountHolderName, double initialDeposit, int pin) {
            this.accountNumber = generateAccountNumber();
            this.accountHolderName = accountHolderName;
            this.balance = initialDeposit;
            this.pin = pin;
        }

        private String generateAccountNumber() {
            Random random = new Random();
            // Generate a 10-digit number
            long number = 1000000000L + random.nextLong(9000000000L);
            return String.valueOf(number);
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public double getBalance() {
            return balance;
        }

        public int getPin() {
            return pin;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            if (balance < amount) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            balance -= amount;
        }
    }

    // Logic Class: Bank
    public static class Bank {
        private Map<String, Account> accounts;
        private final double MIN_BALANCE = 100.0;

        public Bank() {
            this.accounts = new HashMap<>();
        }

        public double getMinBalance() {
            return MIN_BALANCE;
        }

        public Account createAccount(String name, double initialDeposit, int pin) {
            if (initialDeposit < MIN_BALANCE) {
                throw new IllegalArgumentException("Initial deposit must be at least $" + MIN_BALANCE);
            }
            Account newAccount = new Account(name, initialDeposit, pin);
            accounts.put(newAccount.getAccountNumber(), newAccount);
            return newAccount;
        }

        public Account login(String accountNumber, int pin) {
            Account account = accounts.get(accountNumber);
            if (account == null || account.getPin() != pin) {
                return null;
            }
            return account;
        }

        public void deposit(String accountNumber, double amount) {
            Account account = accounts.get(accountNumber);
            if (account != null) {
                account.deposit(amount);
            }
        }

        public void withdraw(String accountNumber, double amount) {
            Account account = accounts.get(accountNumber);
            if (account != null) {
                account.withdraw(amount);
            }
        }
    }
}