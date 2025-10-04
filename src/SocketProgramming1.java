import java.net.*;
import java.util.*;

class TeacherUDPServer {
    public static void main(String[] args) {
        Map<String, Double> teacherSalaries = new HashMap<>();

        try {
            // Create a DatagramSocket on port 5000
            DatagramSocket socket = new DatagramSocket(5000);
            System.out.println("UDP Server started on port 5000.");

            byte[] buffer = new byte[1024];
            while (true) {
                // Receive packet from client
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Extract data
                String received = new String(packet.getData(), 0, packet.getLength());
                String[] data = received.split(",");
                String name = data[0];
                double salary = Double.parseDouble(data[1]);

                // Store in HashMap
                teacherSalaries.put(name, salary);
                System.out.println("Received: Teacher = " + name + ", Salary = " + salary);

                // Send response to client
                String response = "Teacher " + name + " with salary " + salary + " added.";
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData, responseData.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);

                // Print stored data
                System.out.println("Current Teacher Data: " + teacherSalaries);
            }
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}