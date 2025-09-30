import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class EventHandler1 implements ActionListener {
    swing3 s;
    EventHandler1(swing3 s){
        this.s=s;
    }
    public void actionPerformed(ActionEvent e)
    {
        String s1 = s.t1.getText();

    }
}

class swing3 {
    JTextField t1,t2,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5,name;
    JButton b1;
    EventHandler e1;

    swing3() {
        l1 = new JLabel("C :");
        l2 = new JLabel("Python :");
        l3 = new JLabel("Advance Python :");
        l4 = new JLabel("Java :");
        //e1 = new EventHandler1(this);



    }
    public static void main(String[] args) {
        swing3 obj = new swing3();
        JFrame jf = new JFrame("Simple Swing App");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.add(obj.t1);
        jf.add(obj.t2);
        jf.add(obj.t3);
        jf.add(obj.t4);
        jf.add(obj.t5);
        jf.add(obj.b1,"Submit");
        obj.t1.setBounds(50, 20, 200, 30);
        obj.t2.setBounds(50, 40, 200, 30);
        obj.t3.setBounds(50, 60, 200, 30);
        obj.t4.setBounds(50, 80, 200, 30);
        obj.t5.setBounds(50, 100, 200, 30);
        jf.setVisible(true);


    }
}
