// This is to understand basic if else statement (conditional statements).
public class input {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 20;
        int n3 = 15;

        if (n1 >= n2) {
            if (n1 >= n3) {
                System.out.println(n1 + " is the largest number.");
            } else {
                System.out.println(n3 + " is the largest number.");
            }
        } else {
            if (n2 >= n3) {
                System.out.println(n2 + " is the largest number.");
            } else {
                System.out.println(n3 + " is the largest number.");
            }
        }

    }
}