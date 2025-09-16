// Import the Scanner class from the java.util package to handle user input
import java.util.Scanner;

// Class declaration. The class name 'HelloUserInput' matches the file name.
// 'public' makes the class accessible from anywhere.
public class userInput {
    // The main method is the entry point of the program.
    // 'public' allows the JVM to access it.
    // 'static' means it can be called without creating an instance of the class.
    // 'void' indicates it returns no value.
    // 'String[] args' holds command-line arguments (not used here).
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console (System.in).
        // System.in represents the standard input stream (keyboard).
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their name.
        // System.out.println prints the message to the console with a new line.
        System.out.println("Please enter your name: ");

        // Read a line of text (String) entered by the user.
        // nextLine() waits for the user to type input and press Enter, then returns it.
        String userName = scanner.nextLine();

        // Print a personalized greeting using the user's input.
        // The '+' operator concatenates strings in Java.
        System.out.println("Hello, " + userName + "!");

        // Close the Scanner to prevent resource leaks.
        // This is good practice to free up system resources.
        scanner.close();
    }
}