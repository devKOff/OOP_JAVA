import java.util.Scanner;

public class d2array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter columns: ");
        int columns = scanner.nextInt();
        int[][] twoDArray = new int[rows][columns];
        System.out.println("Enter elements in array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoDArray[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The 2D array is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}