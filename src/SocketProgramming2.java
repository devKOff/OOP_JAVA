import java.net.*;

class TeacherUDPClient {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket
            DatagramSocket socket = new DatagramSocket();

            // Prepare data to send
            String name = "Priya";
            double salary = 45000.75;
            String message = name + "," + salary;
            byte[] data = message.getBytes();

            // Send packet to server (localhost:5000)
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 5000);
            socket.send(packet);
            System.out.println("Sent to server: " + message);

            // Receive response
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server response: " + response);

            // Close socket
            socket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}