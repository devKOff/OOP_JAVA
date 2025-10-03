import java.util.Scanner;
import java.util.InputMismatchException;

class InvalidPin extends RuntimeException {
    public InvalidPin(String message) {
        super(message);
    }
}

class Pin {
    private final int correctPin = 12345;
    private int attemptCount = 0;

    public boolean verifyPin(int enteredPin) {
        if (enteredPin == correctPin) {
            System.out.println("\nPIN Accepted! Access Granted.");
            return true;
        } else {
            attemptCount++;
            if (attemptCount >= 3) {
                throw new InvalidPin("invalid attempts.");
            } else {
                System.out.println("Incorrect PIN. " + (3 - attemptCount) + " attempt(s) remaining.");
                return false;
            }
        }
    }
}

public class EnterPin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pin pinValidator = new Pin();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your PIN: ");
            try {
                int userPin = scanner.nextInt();

                if (pinValidator.verifyPin(userPin)) {
                    break;
                }

            } catch (InvalidPin e) {
                System.out.println(e.getMessage());
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next();
                i--;
            }
        }

        scanner.close();
    }
}