import javax.swing.*;

class SwingFrame{
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1=new JLabel("Hello World");
        JTextField t1 =  new JTextField();
        JButton b1 = new JButton("Click");

        jf.add(l1);
        jf.add(t1);
        jf.add(b1);

    }
}



