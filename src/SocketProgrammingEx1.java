import java.io.*;
import java.net.*;
import java.util.*;

// Server program to receive and store teacher data
class MiniTeacherServer {
    public static void main(String[] args) {
        // Map to store teacher name and salary
        Map<String, Double> teacherSalaries = new HashMap<>();

        try {
            // Create a ServerSocket to listen on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Set up input stream to read from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Set up output stream to send response to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from client (format: "name,salary")
            String input = in.readLine();
            String[] data = input.split(","); // Split input into name and salary
            String name = data[0];
            double salary = Double.parseDouble(data[1]);

            // Store data in HashMap
            teacherSalaries.put(name, salary);
            System.out.println("Received: " + name + ", " + salary);

            // Send confirmation to client
            out.println("Added: " + name + ", " + salary);

            // Print stored data
            System.out.println("Teacher Data: " + teacherSalaries);

            // Close client connection
            clientSocket.close();
            // Close server socket (single-use server for simplicity)
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}