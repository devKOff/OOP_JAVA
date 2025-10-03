import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        char operator;
        Double number1, number2, result;

        Scanner input = new Scanner(System.in);

        // Ask the user to enter the operator
        System.out.println("Choose an operator: +, -, *, or /");
        operator = input.next().charAt(0);

        // Ask the user to enter two numbers
        System.out.println("Enter first number");
        number1 = input.nextDouble();

        System.out.println("Enter second number");
        number2 = input.nextDouble();

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            case '-':
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            case '*':
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                    System.out.println(number1 + " / " + number2 + " = " + result);
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                }
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }
        input.close();
    }
}