import java.util.Scanner;
class Account {
    private double bal = 10000;
    boolean checkAmount(double amt) {
        if (bal > amt) {
            return true;
        }
        else {
            return false;
        }
    }

    public double withdraw(double amt) {
        bal = bal - amt;
        return bal;
    }
}

class Customer extends Thread {
    Account ac;
    Customer(Account ac) {
        this.ac = ac;
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw:");
        double amt = sc.nextDouble();
        if (ac.checkAmount(amt)) {
            System.out.println("Remaining Balance: " + ac.withdraw(amt));
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class account2 {
    public static void main(String[] args) {
        Account ac = new Account();
        Customer c1 = new Customer(ac);
        Customer c2 = new Customer(ac);
        c1.start();
        c2.start();
    }
}
