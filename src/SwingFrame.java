import javax.swing.*;
import java.awt.*;

class SwingFrame {
    public static void main(String[] args) {

        JFrame jf = new JFrame("Enter");
        jf.setLayout(new FlowLayout());


        JLabel l1 = new JLabel("Enter your name :");
        JButton b1 = new JButton("Click");
        JTextField t1 = new JTextField(15);
        jf.add(l1);
        jf.add(t1);
        jf.add(b1);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 300);
        jf.setVisible(true);
    }
}