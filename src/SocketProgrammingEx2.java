import java.io.*;
import java.net.*;

// Client program to send teacher data to server
class MiniTeacherClient {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost, port 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server");

            // Set up output stream to send data to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // Set up input stream to read server response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Prepare teacher data
            String name = "Priya";
            double salary = 45000.75;
            String message = name + "," + salary; // Format data as "name,salary"

            // Send data to server
            out.println(message);
            System.out.println("Sent: " + message);

            // Read and print server response
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}