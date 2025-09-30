import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SwingFormSetBounds {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Student Marks Form");
        jf.setLayout(null);

        JLabel l1 = new JLabel("Enter your name:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Enter five subject marks:");

        JLabel l3 = new JLabel("C:");
        JTextField t2 = new JTextField();

        JLabel l4 = new JLabel("Python:");
        JTextField t3 = new JTextField();

        JLabel l5 = new JLabel("Advanced Python:");
        JTextField t4 = new JTextField();

        JLabel l6 = new JLabel("JAVA:");
        JTextField t5 = new JTextField();

        JLabel l7 = new JLabel("C++:");
        JTextField t6 = new JTextField();

        JLabel l8 = new JLabel("Average of marks:");
        JTextField t7 = new JTextField();
        t7.setEditable(false); // Make average field read-only

        JButton b1 = new JButton("Calculate Total & Average");

        // Set bounds for components
        l1.setBounds(30, 20, 120, 25);
        t1.setBounds(160, 20, 200, 25);

        l2.setBounds(30, 60, 200, 25);

        l3.setBounds(30, 90, 120, 25);
        t2.setBounds(160, 90, 200, 25);

        l4.setBounds(30, 120, 120, 25);
        t3.setBounds(160, 120, 200, 25);

        l5.setBounds(30, 150, 120, 25);
        t4.setBounds(160, 150, 200, 25);

        l6.setBounds(30, 180, 120, 25);
        t5.setBounds(160, 180, 200, 25);

        l7.setBounds(30, 210, 120, 25);
        t6.setBounds(160, 210, 200, 25);

        b1.setBounds(200, 240, 160, 25);

        l8.setBounds(30, 270, 120, 25);
        t7.setBounds(160, 270, 200, 25);

        // Add components to frame
        jf.add(l1);
        jf.add(t1);
        jf.add(l2);
        jf.add(l3);
        jf.add(t2);
        jf.add(l4);
        jf.add(t3);
        jf.add(l5);
        jf.add(t4);
        jf.add(l6);
        jf.add(t5);
        jf.add(l7);
        jf.add(t6);
        jf.add(l8);
        jf.add(t7);
        jf.add(b1);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);
        jf.setVisible(true);
    }
}